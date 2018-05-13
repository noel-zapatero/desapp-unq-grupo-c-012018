package main.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/**
 * Interface for generic DAO
 *
 * @param <T>
 */
public interface GenericRepository<T> {

  @Transactional
  void save(T entity);

  void delete(T entity);

  void update(T entity);

  @Transactional
  T findById(Serializable id);

  List<T> findAll();

  void deleteById(Serializable id);

  int count();

  List<T> findByExample(T exampleObject);

}
