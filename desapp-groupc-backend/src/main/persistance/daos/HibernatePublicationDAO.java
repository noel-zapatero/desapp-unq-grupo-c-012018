package main.persistance.daos;

import main.model.Publication;
import main.persistance.service.Runner;
import org.hibernate.Session;

public class HibernatePublicationDAO {

  public void save(Publication publication) {
    Session session = Runner.getCurrentSession();
    session.save(publication);
  }

  public Publication get (Long id) {
    Session session = Runner.getCurrentSession();
    return session.get(Publication.class, id);
  }
}
