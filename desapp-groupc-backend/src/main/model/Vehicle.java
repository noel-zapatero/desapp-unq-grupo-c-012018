package main.model;

import main.model.availability.Availability;
import org.joda.time.DateTime;

import java.util.List;

public class Vehicle {

    private VehicleType type;
    private int passengerCapacity;
    private String zone;
    private Adress withdrawAdress;
    private List<Adress> returnAdress;
    private String description;
    private Phone contactPhone;
    private Availability availability;
    private float rentFeeDay;
    private float rentFeeHour;

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setWithdrawAdress(Adress withdrawAdress) {
        this.withdrawAdress = withdrawAdress;
    }

    public void setReturnAdress(List<Adress> returnAdress) {
        this.returnAdress = returnAdress;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactPhone(Phone contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public void setRentFeeDay(float rentFeeDay) {
        this.rentFeeDay = rentFeeDay;
    }

    public void setRentFeeHour(float rentFeeHour) {
        this.rentFeeHour = rentFeeHour;
    }

    public boolean isAvailable(DateTime dateTime) {
        return availability.isAvailable(dateTime);
    }
}
