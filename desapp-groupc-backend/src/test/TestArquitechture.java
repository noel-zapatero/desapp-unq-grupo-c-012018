package test;

import com.sun.source.tree.AssertTree;
import main.model.builders.IBuilder;
import main.repositories.*;
import main.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Entity;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class TestArquitechture {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private VehicleRepository vehicleRepository;

  @Autowired
  private PublicationRepository publicationRepository;

  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  private AvailabilityRepository availabilityRepository;

  public void setUserRepository(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void setVehicleRepository(final VehicleRepository vehicleRepository) { this.vehicleRepository = vehicleRepository; }

  public void setPublicationRepository(final PublicationRepository publicationRepository) { this.publicationRepository = publicationRepository; }

  public void setReservationRepository(final ReservationRepository reservationRepository) { this.reservationRepository = reservationRepository; }

  public void setAvailabilityRepository(final AvailabilityRepository availabilityRepository) { this.availabilityRepository = availabilityRepository; }

  @Test
  public void test_entitiesMappings() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    HashMap<String, GenericRepository<?>> repositoryHashMap = new HashMap<>();
    repositoryHashMap.put("User", userRepository);
    repositoryHashMap.put("Vehicle", vehicleRepository);
    repositoryHashMap.put("Publication", publicationRepository);
    repositoryHashMap.put("Reservation", reservationRepository);
    repositoryHashMap.put("Availability", availabilityRepository);

    Reflections reflections = new Reflections("main/model");
    Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Entity.class);

    List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
    classLoadersList.add(ClasspathHelper.contextClassLoader());
    classLoadersList.add(ClasspathHelper.staticClassLoader());

    reflections = new Reflections(new ConfigurationBuilder()
      .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
      .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
      .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("main/model/builders"))));
    Set<Class<? extends Object>> builders = reflections.getSubTypesOf(Object.class);

    for (Class<?> entitie: entities) {
      List<String> entitieClassPath = Arrays.asList(entitie.getName().split("[.]"));
      String entitieName = entitieClassPath.get(entitieClassPath.size()-1);

      Class<?> builderClass = null;
      for (Class<?> b: builders) {
        if (b.getName().contains(entitieName)) {
          builderClass = b;
          break;
        }
      }

      Object builder = builderClass.newInstance();

      Method buildMethod = builderClass.getMethod("build", null);

      Object enttitieToSave = buildMethod.invoke(builder);

      Class<?> repositoryClass = repositoryHashMap.get(entitieName).getClass();

      Method saveMethod = repositoryClass.getMethod("save", null);

      saveMethod.invoke(repositoryHashMap.get(entitieName), enttitieToSave);

      Method retriveAllMethod = repositoryClass.getMethod("retriveAll", null);

      assertEquals(1, ((List<?>)retriveAllMethod.invoke(repositoryHashMap.get(entitieName))).size());

    }
  }
}
