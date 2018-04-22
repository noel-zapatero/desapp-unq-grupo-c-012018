package main.persistance.service;

import org.hibernate.Session;

import java.io.Serializable;

public class TestService {

  public void createEntity(Object object) {
    Runner.runInSession(() -> {
      Session session = Runner.getCurrentSession();
      session.save(object);
      return null;
    });
  }

  public <T> T getEntity(Class<T> type, Serializable key) {
    return Runner.runInSession(() -> {
      Session session = Runner.getCurrentSession();
      T value = session.get(type, key);
      return value;
    });
  }
}
