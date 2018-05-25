package main.services;

import main.model.Publication;
import main.model.Reservation;

public class PublicationService extends GenericService<Publication> {
  private static final long serialVersionUID = -2932116622242535843L;

  public void acceptReservation(Publication p, Reservation r) {
    p.acceptReservation(r);
    this.update(p);
  }

  public void declineReservation(Publication p, Reservation r) {
    p.declineReservation(r);
    this.update(p);
  }
}
