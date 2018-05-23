package main.repositories;

import main.model.availability.Availability;
import org.apache.log4j.Logger;

public class AvailabilityRepository
  extends HibernateGenericDAO<Availability>
  implements GenericRepository<Availability> {

  public static Logger log  = Logger.getLogger(AvailabilityRepository.class);
  private static final long serialVersionUID = -4036535812105672110L;

  protected Class<Availability> getDomainClass() {
    return Availability.class;
  }
}
