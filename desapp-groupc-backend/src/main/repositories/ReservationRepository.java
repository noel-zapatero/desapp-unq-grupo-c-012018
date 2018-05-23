package main.repositories;

import main.model.Reservation;
import org.apache.log4j.Logger;

public class ReservationRepository
  extends HibernateGenericDAO<Reservation>
  implements GenericRepository<Reservation> {

  public static Logger log  = Logger.getLogger(ReservationRepository.class);
  private static final long serialVersionUID = -4036535812105672110L;

  protected Class<Reservation> getDomainClass() {
    return Reservation.class;
  }
}
