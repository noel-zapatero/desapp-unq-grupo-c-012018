package main.services;

import java.io.Serializable;
import java.util.List;

import main.repositories.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GenericService<T> implements Serializable {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  private static final long serialVersionUID = -6540963495078524186L;

  private GenericRepository<T> repository;

  public GenericRepository<T> getRepository() {
    return this.repository;
  }

  public void setRepository(final GenericRepository<T> repository) {
    this.repository = repository;
  }

  @Transactional
  public void delete(final T object) {
    this.getRepository().delete(object);
  }

  @Transactional(readOnly = true)
  public List<T> retriveAll() {
    return this.getRepository().findAll();
  }

  @Transactional
  public void save(final T object) {
//    sessionFactory.getCurrentSession().save(object);
    this.getRepository().save(object);

    Session session = sessionFactory.getCurrentSession();
//    Transaction transaction = session.beginTransaction();
    session.save(object);
//    transaction.commit();
  }

  @Transactional
  public void update(final T object) {
    this.getRepository().update(object);
  }

  @Transactional(readOnly = true)
  public T findById(int id) {
    return this.getRepository().findById(id);
  }

}
