package main.repositories;

import main.model.User;
import org.apache.log4j.Logger;

public class UserRepository
  extends HibernateGenericDAO<User>
  implements GenericRepository<User> {

  public static Logger log  = Logger.getLogger(UserRepository.class);
  private static final long serialVersionUID = -4036535812105672110L;

  protected Class<User> getDomainClass() {
    return User.class;
  }
}
