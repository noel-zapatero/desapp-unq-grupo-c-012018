package main.persistance.daos;

import main.model.User;
import main.persistance.service.Runner;
import org.hibernate.Session;

public class HibernateUserDAO {

  public void save(User user) {
    Session session = Runner.getCurrentSession();
    session.save(user);
  }

  public User get (Long id) {
    Session session = Runner.getCurrentSession();
    return session.get(User.class, id);
  }
}
