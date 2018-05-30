package main.webservices;

import main.model.dtos.ReservationDto;
import main.services.ReservationService;

import javax.ws.rs.*;

@Path("/reservations")
public class ReservationsRest {
  private ReservationService reservationService;

  public void setReservationService(final ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @PUT
  @Consumes("application/json")
  public void createReservation(ReservationDto rDto) {
    reservationService.saveReservationDto(rDto);
  }

  @Path("/accept/{id}")
  @POST
  public void acceptReservation(@PathParam("id") String id) {
    reservationService.acceptReservation(Integer.valueOf(id));
  }

  @Path("/decline/{id}")
  @POST
  public void declineReseration(@PathParam("id") String id) {
    reservationService.declineReservation(Integer.valueOf(id));
  }
}
