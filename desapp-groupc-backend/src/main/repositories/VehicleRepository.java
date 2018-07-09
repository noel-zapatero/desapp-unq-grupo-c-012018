package main.repositories;

import main.model.Vehicle;
import org.apache.log4j.Logger;

import java.util.List;

public class VehicleRepository
  extends HibernateGenericDAO<Vehicle>
  implements GenericRepository<Vehicle> {

  public static Logger log  = Logger.getLogger(UserRepository.class);
  private static final long serialVersionUID = -4036535812105672110L;

  protected Class<Vehicle> getDomainClass() {
    return Vehicle.class;
  }

  public List<Vehicle> filterByType(String type) {
    return (List<Vehicle>) this.getHibernateTemplate()
      .find("from Vehicle where type='" + type + "'");
  }
}
