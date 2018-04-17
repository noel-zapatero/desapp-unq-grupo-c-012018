package test;

import junit.framework.TestCase;
import main.model.Publication;
import main.model.Reservation;
import main.model.availability.Available;
import main.model.builders.PublicationBuilder;
import main.model.builders.VehicleBuilder;
import org.joda.time.DateTime;

public class TestPublication extends TestCase {

  public void testVehiclesFirstStartAsUnavailable() {
    Publication p = new PublicationBuilder()
      .withVehicle(new VehicleBuilder().build())
      .build();

    assertFalse(p.isAvailable(today(), today().plusHours(1)));
  }

  public void testMakeAVehicleAvailable() {
    Publication p = todayTomorrowVehicle();

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

  public void testBookAVehicleAndSeeThatIsNotAvailableAtTheTimeBooked() {
    Publication p = todayTomorrowVehicle();
    Reservation r = p.book(DateTime.now(), DateTime.now().plusHours(1), "someUser");
    r.accept();
    assertFalse(p.isAvailable(DateTime.now(), DateTime.now().plusHours(1)));
  }

  private Publication todayTomorrowVehicle() {
    return new PublicationBuilder()
      .withAvailability(new Available(today(), tomorrow()))
      .build();
  }

}
