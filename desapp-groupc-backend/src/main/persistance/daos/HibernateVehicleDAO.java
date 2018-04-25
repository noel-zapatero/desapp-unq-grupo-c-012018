//package main.persistance.daos;
//
//import main.model.Vehicle;
//import main.persistance.service.Runner;
//import org.hibernate.Session;
//
//public class HibernateVehicleDAO {
//
//  public void save(Vehicle vehicle) {
//    Session session = Runner.getCurrentSession();
//    session.save(vehicle);
//  }
//
//  public Vehicle get (Long id) {
//    Session session = Runner.getCurrentSession();
//    return session.get(Vehicle.class, id);
//  }
//
//}
