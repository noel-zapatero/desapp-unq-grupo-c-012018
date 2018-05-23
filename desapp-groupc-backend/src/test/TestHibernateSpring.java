package test;

import main.model.Publication;
import main.model.Reservation;
import main.model.User;
import main.model.Vehicle;
import main.model.Availability;
import main.model.builders.PublicationBuilder;
import main.model.builders.ReservationBuilder;
import main.model.builders.UserBuilder;
import main.model.builders.VehicleBuilder;
import main.services.*;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class TestHibernateSpring {

  @Autowired
  private UserService userService;

  @Autowired
  private VehicleService vehicleService;

  @Autowired
  private PublicationService publicationService;

  @Autowired
  private ReservationService reservationService;

  @Autowired
  private AvailabilityService availabilityService;

  public void setUserService(final UserService userService) {
    this.userService = userService;
  }

  public void setVehicleService(final VehicleService vehicleService) { this.vehicleService = vehicleService; }

  public void setPublicationService(final PublicationService publicationService) { this.publicationService = publicationService; }

  public void setReservationService(final ReservationService reservationService) { this.reservationService = reservationService; }

  public void setAvailabilityService(final AvailabilityService availabilityService) { this.availabilityService = availabilityService; }

  @Test
  public void test_userBasicPersistence() {
    User u = new UserBuilder()
      .withEmail("l@l.com")
      .withNameAndLastName("Luky", "Lala")
      .withAddress("Fake Street 123")
      .withCuil(20000000001L)
      .build();

    userService.save(u);

    User u2 = userService.findById(u.getId());

    assertEquals(u.getId(), u2.getId());
    assertEquals(u.getRating(), u2.getRating());
    assertEquals(u.getCredits(), u2.getCredits());
    assertEquals(u.getName(), u2.getName());
    assertEquals(u.getEmail(), u2.getEmail());
  }

  @Test
  public void test_vehicleBasicPersistence() {
    Vehicle v = new VehicleBuilder().build();
    vehicleService.save(v);
    assertEquals(1, vehicleService.retriveAll().size());
  }

  @Test
  public void test_publicationsBasicPersistence() {
    Availability a = new Availability(DateTime.now(), DateTime.now().plusDays(1));

    availabilityService.save(a);

    Publication p = new PublicationBuilder()
      .withAvailability(a)
      .build();

    publicationService.save(p);

    assertEquals(1, publicationService.retriveAll().size());
  }

  @Test
  public void test_reservationsBasicPersistence() {
    User u = new UserBuilder()
      .withNameAndLastName("Nowels", "Man")
      .build();

    userService.save(u);

    Reservation r = new ReservationBuilder().withUser(u).build();

    reservationService.save(r);

    assertEquals("Nowels", reservationService.findById(r.getId()).getUser().getName());
  }

  @Test
  public void test_persistUserWithAVehicle() {
    User u = new UserBuilder()
      .withEmail("l@l.com")
      .withNameAndLastName("Luky", "Lala")
      .withAddress("Fake Street 123")
      .withCuil(20000000001L)
      .build();

    Vehicle v = new VehicleBuilder().withPassengerAmmount(5).build();

    vehicleService.save(v);

    u.addVehicle(v);

    userService.save(u);

    User u2 = userService.findById(u.getId());

    assertEquals(5, u2.getVehicles().get(0).getPassengerCapacity());
  }

}
