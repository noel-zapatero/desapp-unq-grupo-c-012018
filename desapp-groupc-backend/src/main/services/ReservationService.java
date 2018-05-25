package main.services;

import main.model.Publication;
import main.model.Reservation;
import main.model.builders.ReservationBuilder;
import main.model.dtos.ReservationDto;

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
    this.save(
      new ReservationBuilder()
        .withStartDate(rDto.getStart())
        .withEndDate(rDto.getEnd())
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
}
