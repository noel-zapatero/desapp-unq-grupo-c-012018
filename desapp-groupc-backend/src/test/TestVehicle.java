package test;

import junit.framework.TestCase;
import main.model.availability.Availability;
import main.model.availability.DailyAvailability;
import main.model.availability.RangeAvailability;
import main.model.availability.AllwaysAvailable;
import main.model.Vehicle;
import main.model.builders.VehicleBuilder;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class TestVehicle extends TestCase {

    public void testCreateAVehicleThatIsAvailableAllTheTime() {
        Vehicle v = new VehicleBuilder()
                .withAvailability(new AllwaysAvailable())
                .build();

        assertTrue(v.isAvailable(DateTime.now()));
    }

    public void testCreateAVehicleThatIsAvailable5DaysStartingTomorrow() {
        Vehicle v = new VehicleBuilder()
                .withAvailability(new RangeAvailability(
                        DateTime.now().plusDays(1),
                        DateTime.now().plusDays(6))
                )
                .build();

        assertFalse(v.isAvailable(DateTime.now()));

        assertTrue(v.isAvailable(DateTime.now().plusDays(1)));
        assertTrue(v.isAvailable(DateTime.now().plusDays(2)));
        assertTrue(v.isAvailable(DateTime.now().plusDays(3)));
        assertTrue(v.isAvailable(DateTime.now().plusDays(4)));
        assertTrue(v.isAvailable(DateTime.now().plusDays(5)));

        assertFalse(v.isAvailable(DateTime.now().plusDays(6)));
    }

    public void testCreateAVehicleThatIsAvailableDailyFrom6to18() {
      Vehicle v = new VehicleBuilder()
        .withAvailability(
          new DailyAvailability(
            new LocalTime(6,0),
            new LocalTime(18,0)
          )
        )
        .build();

      assertFalse(v.isAvailable(DateTime.now().withTime(new LocalTime(5,0))));
      assertTrue(v.isAvailable(DateTime.now().plusDays(1).withTime(new LocalTime(6,0))));
      assertTrue(v.isAvailable(DateTime.now().plusDays(2).withTime(new LocalTime(7,0))));
      assertTrue(v.isAvailable(DateTime.now().plusDays(3).withTime(new LocalTime(16,0))));
      assertFalse(v.isAvailable(DateTime.now().plusDays(4).withTime(new LocalTime(18,0))));
    }

}
