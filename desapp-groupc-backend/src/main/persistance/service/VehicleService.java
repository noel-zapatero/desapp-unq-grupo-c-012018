package main.persistance.service;

import main.model.Vehicle;
import main.persistance.daos.HibernateVehicleDAO;

public class VehicleService  {

  private HibernateVehicleDAO vehicleDAO;

  public VehicleService(HibernateVehicleDAO vehicleDAO){
    this.vehicleDAO = vehicleDAO;
  }
}
