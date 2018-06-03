package main.repositories;

import main.model.User;
import org.apache.log4j.Logger;

import java.util.List;

public class UserRepository
  extends HibernateGenericDAO<User>
  implements GenericRepository<User> {

  public static Logger log  = Logger.getLogger(UserRepository.class);
  private static final long serialVersionUID = -4036535812105672110L;

  protected Class<User> getDomainClass() {
    return User.class;
  }

  public User findByEmail(String email) {
    List<User> find =
      (List<User>) this.getHibernateTemplate().findByNamedParam(
        "from User where email=:email",
        "email",
        email);

    if (find.size() == 0)
      return null;
    else
      return find.get(0);
  }
}
