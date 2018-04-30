package main.persistance.service;

import main.persistance.daos.HibernateUserDAO;

public class UserService {

  private HibernateUserDAO userDAO;

  public UserService(HibernateUserDAO userDAO){
    this.userDAO = userDAO;
  }
}
