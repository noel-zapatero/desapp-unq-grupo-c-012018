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

  private UserService uService;
  private PublicationService pService;

  public void setUserService(UserService uService) {
    this.uService = uService;
  }

  public void setPublicationService(PublicationService pService) {
    this.pService = pService;
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
        .withUser(uService.findById(rDto.getUserId()))
        .withPublication(pService.findById(rDto.getPublicationId()))
        .build()
    );
  }

  public void acceptReservation(int rId) {
    Reservation r = this.findById(rId);
    Publication p = r.getPublication();
    pService.acceptReservation(p, r);
  }

  public void declineReservation(int rId) {
    Reservation r = this.findById(rId);
    Publication p = r.getPublication();
    pService.declineReservation(p, r);
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
}
