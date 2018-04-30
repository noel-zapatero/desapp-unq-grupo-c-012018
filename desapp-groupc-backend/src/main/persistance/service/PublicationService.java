package main.persistance.service;

import main.persistance.daos.HibernatePublicationDAO;

public class PublicationService {

  private HibernatePublicationDAO publicationDAO;

  public PublicationService(HibernatePublicationDAO publicationDAO){
    this.publicationDAO = publicationDAO;
  }
}
