package test;

import junit.framework.TestCase;
import main.model.availability.Availability;
import main.model.Publication;
import main.model.Vehicle;
import main.model.availability.Available;
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
    Publication p = new PublicationBuilder()
      .withAvailability(new Available(today(), tomorrow()))
      .build();

    assertTrue(p.isAvailable(today(), today().plusHours(1)));
    assertTrue(p.isAvailable(tomorrow().minusHours(1), tomorrow()));
    assertFalse(p.isAvailable(tomorrow(), tomorrow().plusHours(1)));
  }

  private DateTime tomorrow() {
    return today().plusDays(1);
  }

  private DateTime today() {
    return DateTime.now();
  }

  public void test_bookAVehicleAndSeeThatIsNotAvailableAtTheTimeBooked() {

  }

}
