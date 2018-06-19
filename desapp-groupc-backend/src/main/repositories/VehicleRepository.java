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

  public Vehicle findVehicleById(Integer id){
    List<Vehicle> find =
      (List<Vehicle>) this.getHibernateTemplate().findByNamedParam(
        "from Vehicle where id=:id",
        "id",
        id);

    if (find.size() == 0)
      return null;
    else
      return find.get(0);
  }
}
