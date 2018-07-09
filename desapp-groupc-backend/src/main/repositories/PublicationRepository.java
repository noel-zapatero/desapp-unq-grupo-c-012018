package main.repositories;

import main.model.Publication;
import org.apache.log4j.Logger;

import java.util.List;

public class PublicationRepository
  extends HibernateGenericDAO<Publication>
  implements GenericRepository<Publication> {

  public static Logger log  = Logger.getLogger(PublicationRepository.class);
  private static final long serialVersionUID = -4036535812105672110L;

  protected Class<Publication> getDomainClass() {
    return Publication.class;
  }

  public List<Publication> filterByVehicleType(String vehicleType) {
    return (List<Publication>) getHibernateTemplate()
      .find("select p " +
        "from Publication p " +
        "join p.vehicleOffered v " +
        "where v.type='" + vehicleType + "'");
  }

}
