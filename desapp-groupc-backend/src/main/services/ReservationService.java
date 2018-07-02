package main.services;

import main.model.Publication;
import main.model.Reservation;
import main.model.builders.ReservationBuilder;
import main.model.dtos.ReservationDto;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class ReservationService extends GenericService<Reservation> {
  private static final long serialVersionUID = -2932116622242535843L;

  private UserService userService;
  private PublicationService publicationService;

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public void setPublicationService(PublicationService publicationService) {
    this.publicationService = publicationService;
  }

  public void saveReservationDto(ReservationDto rDto) {
    DateTime startDate =
      new DateTime(rDto.getStartYear(), rDto.getStartMonth(), rDto.getStartDayOfMonth(), 1, 1);

    DateTime endDate =
      new DateTime(rDto.getEndYear(), rDto.getEndMonth(), rDto.getEndDayOfMonth(), 1, 1);

    this.save(
      new ReservationBuilder()
        .withStartDate(startDate)
        .withEndDate(endDate)
        .withUser(userService.findByEmail(rDto.getUserEmail()))
        .withPublication(publicationService.findById(rDto.getPublicationId()))
        .build()
    );
  }

  public void acceptReservation(int rId) {
    Reservation r = this.findById(rId);
    Publication p = r.getPublication();
    publicationService.acceptReservation(p, r);
    update(r);
  }

  public void declineReservation(int rId) {
    Reservation r = this.findById(rId);
    Publication p = r.getPublication();
    publicationService.declineReservation(p, r);
    r.setPublication(null);
    delete(r);
  }

  public List<ReservationDto> getReservationsOf(int pubId) {
    List<ReservationDto> reservations = new ArrayList<>();
    for (Reservation reservation: retriveAll()) {
      if (reservation.getPublication().getId() == pubId) {
        reservations.add(new ReservationDto(reservation));
      }
    }
    return reservations;
  }

  // retorna null si no hay
  public ReservationDto getMyReservationOf(String userEmail, int pubId) {
    ReservationDto reservation = null;
    for (Reservation r: retriveAll()) {
      if (r.getPublication().getId() == pubId && r.getUserEmail().equals(userEmail)) {
        reservation = new ReservationDto(r);
      }
    }
    return reservation;
  }

  public ReservationDto createReservation(ReservationDto rDto) {
    int pubid = rDto.getPublicationId();
    Publication publication = publicationService.findById(pubid);
    Reservation reservation = new ReservationBuilder()
      .withStartDate(new DateTime(
        rDto.getStartYear(),
        rDto.getStartMonth(),
        rDto.getStartDayOfMonth(), 1,1))
      .withEndDate(new DateTime(
        rDto.getEndYear(),
        rDto.getEndMonth(),
        rDto.getEndDayOfMonth(), 1,1))
      .withUser(userService.findByEmail(rDto.getUserEmail()))
      .withPublication(publication)
      .withRetireState(rDto.getRetireState())
      .build();

    save(reservation);

    return new ReservationDto(reservation);
  }

  public ReservationDto retireVehicle(int reservationId) {
    Reservation reservation = findById(reservationId);
    reservation.retire();
    update(reservation);
    return new ReservationDto(reservation);
  }

  public ReservationDto acceptRetire(int reservationId) {
    Reservation reservation = findById(reservationId);
    reservation.acceptRetire();
    update(reservation);
    return new ReservationDto(reservation);
  }

  public ReservationDto returnVehicle(Integer reservationId) {
    Reservation reservation = findById(reservationId);
    reservation.returnVehicle();
    update(reservation);
    return new ReservationDto(reservation);
  }

  public ReservationDto acceptReturn(Integer reservationId) {
    Reservation reservation = findById(reservationId);
    reservation.acceptReturn();
    update(reservation);
    return new ReservationDto(reservation);
  }
}
