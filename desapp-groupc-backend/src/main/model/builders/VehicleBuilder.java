package main.model.builders;

import main.model.availability.Availability;
import main.model.Vehicle;

public class VehicleBuilder {

    private Availability availability;

    public VehicleBuilder withAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public Vehicle build() {
        Vehicle v = new Vehicle();

        v.setAvailability(this.availability);

        return v;
    }
}
