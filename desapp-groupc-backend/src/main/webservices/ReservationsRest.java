package main.webservices;

import main.model.dtos.ReservationDto;
import main.services.ReservationService;

import javax.ws.rs.*;

@Path("/reservations")
public class ReservationsRest {
  private ReservationService rService;

  public void setReservationService(final ReservationService rService) {
    this.rService = rService;
  }

  @PUT
  @Consumes("application/json")
  public void createReservation(ReservationDto rDto) {
    rService.saveReservationDto(rDto);
  }

  @Path("/accept/{id}")
  @POST
  public void acceptReservation(@PathParam("id") String id) {
    rService.acceptReservation(Integer.valueOf(id));
  }

  @Path("/decline/{id}")
  @POST
  public void declineReseration(@PathParam("id") String id) {
    rService.declineReservation(Integer.valueOf(id));
  }
}
