package test;

import junit.framework.TestCase;
import main.model.Availability;
import main.model.Publication;
import main.model.Vehicle;
import main.model.builders.PublicationBuilder;
import main.model.builders.VehicleBuilder;
import org.joda.time.DateTime;

public class TestVehicle extends TestCase {

  public void test_vehiclesFirstStartAsUnavailable() {
    Publication p = new PublicationBuilder()
      .withVehicle(new VehicleBuilder().build())
      .build();

    assertFalse(p.isAvailable(today(), today().plusHours(1)));
  }

  public void test_makeAVehicleAvailable() {
    Vehicle v = new VehicleBuilder()
      .withAvailability(new Availability(today(), tomorrow()))
      .build();

    assertTrue(v.isAvailable(today(), today().plusHours(1)));
    assertTrue(v.isAvailable(tomorrow().minusHours(1), tomorrow()));
    assertFalse(v.isAvailable(tomorrow(), tomorrow().plusHours(1)));
  }

  private DateTime tomorrow() {
    return today().plusDays(1);
  }

  private DateTime today() {
    return DateTime.now();
  }

  public void test_bookAVehicleAndSeeThatIsNotAvailableAtTheTimeBooked() {
    Vehicle v = new VehicleBuilder()
      .withAvailability(new Availability(today(), today().plusDays(3)))
      .build();
  }

}
