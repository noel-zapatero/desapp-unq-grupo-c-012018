package main.persistance.daos;

import main.model.Reservation;
import main.persistance.service.Runner;
import org.hibernate.Session;

public class HibernateReservationDAO {

  public void save(Reservation reservation) {
    Session session = Runner.getCurrentSession();
    session.save(reservation);
  }

  public Reservation get (Long id) {
    Session session = Runner.getCurrentSession();
    return session.get(Reservation.class, id);
  }
}
