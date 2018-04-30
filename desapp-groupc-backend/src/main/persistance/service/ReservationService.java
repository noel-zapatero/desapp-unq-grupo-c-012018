package main.persistance.service;

import main.persistance.daos.HibernateReservationDAO;

public class ReservationService {

  private HibernateReservationDAO reservationDAO;

  public ReservationService(HibernateReservationDAO reservationDAO){
    this.reservationDAO = reservationDAO;
  }
}
