package test;

import main.model.Publication;
import main.model.Reservation;
import main.model.availability.Availability;
import main.model.builders.PublicationBuilder;
import main.model.builders.UserBuilder;
import main.model.builders.VehicleBuilder;
import org.joda.time.DateTime;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestPublication {

  @Test
  public void testVehiclesFirstStartAsUnavailable() {
    Publication p = new PublicationBuilder()
      .withVehicle(new VehicleBuilder().build())
      .build();

    assertFalse(p.isAvailable(today(), today().plusHours(1)));
  }

  @Test
  public void testMakeAVehicleAvailable() {
    Publication p = todayTomorrowVehicle();

    assertTrue(p.isAvailable(today(), today().plusHours(1)));
    assertTrue(p.isAvailable(tomorrow().minusHours(1), tomorrow()));
    assertFalse(p.isAvailable(tomorrow(), tomorrow().plusHours(1)));
  }

  public DateTime tomorrow() {
    return today().plusDays(1);
  }

  public DateTime today() {
    return DateTime.now();
  }

  @Test
  public void testBookAVehicleAndSeeThatIsNotAvailableAtTheTimeBooked() {
    Publication p = todayTomorrowVehicle();
    Reservation r = p.book(DateTime.now(), DateTime.now().plusHours(1), new UserBuilder().build());
    r.accept();
    assertFalse(p.isAvailable(DateTime.now(), DateTime.now().plusHours(1)));
  }

  public Publication todayTomorrowVehicle() {
    return new PublicationBuilder()
      .withAvailability(new Availability(today(), tomorrow()))
      .build();
  }

}
