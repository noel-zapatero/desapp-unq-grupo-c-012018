package test;

import junit.framework.TestCase;
import main.model.availability.RangeAvailability;
import main.model.availability.AlwaysAvailable;
import main.model.Vehicle;
import main.model.builders.VehicleBuilder;
import org.joda.time.DateTime;

public class TestVehicle extends TestCase {

    public void testCreateAVehicleThatIsAvailableAllTheTime() {
        Vehicle v = new VehicleBuilder()
                .withAvailability(new AlwaysAvailable())
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

}
