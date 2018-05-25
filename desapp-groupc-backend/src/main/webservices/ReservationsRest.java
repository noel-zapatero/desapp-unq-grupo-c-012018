package main.webservices;

import main.services.ReservationService;

import javax.ws.rs.Path;

@Path("/reservations")
public class ReservationsRest {
  private ReservationService rService;

  public void setReservationService(final ReservationService rService) {
    this.rService = rService;
  }
}
