package main.webservices;

import main.model.dtos.PublicationDto;
import main.model.dtos.ReservationDto;
import main.services.ReservationService;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/reservations")
@CrossOriginResourceSharing(allowAllOrigins = true)
public class ReservationsRest {
  private ReservationService reservationService;

  public void setReservationService(final ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @GET
  @Path("/reservationsof/{pubId}")
  @Produces("application/json")
  public Response getReservationsOf(@PathParam("pubId") String pubId) {
    List<ReservationDto> reservations = this.reservationService.getReservationsOf(Integer.valueOf(pubId));
    return Response.ok(reservations).build();
  }

  @GET
  @Path("/myreservationof/{userEmail}/{pubId}")
  @Produces("application/json")
  public Response getMyReservationOf(
    @PathParam("userEmail") String userEmail,
    @PathParam("pubId") String pubId)
  {
    ReservationDto reservation =
      reservationService.getMyReservationOf(userEmail, Integer.valueOf(pubId));

    return Response.ok(reservation).build();
  }

  @POST
  @Consumes("application/json")
  public Response createReservation(ReservationDto rDto) {
    ReservationDto ret = reservationService.createReservation(rDto);
    return Response.ok(ret).build();
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

  @Path("/retire/{reservationId}")
  @PUT
  @Produces("application/json")
  public Response retireVehicle(@PathParam("reservationId") String reservationId) {
    ReservationDto reservation = this.reservationService.retireVehicle(Integer.valueOf(reservationId));
    return Response.ok(reservation).build();
  }

  @Path("/acceptretire/{reservationId}")
  @PUT
  @Produces("application/json")
  public Response acceptRetire(@PathParam("reservationId") String reservationId) {
    ReservationDto reservation = this.reservationService.acceptRetire(Integer.valueOf(reservationId));
    return Response.ok(reservation).build();
  }

  @Path("/return/{reservationId}")
  @PUT
  @Produces("application/json")
  public Response returnVehicle(@PathParam("reservationId") String reservationId) {
    ReservationDto reservation = this.reservationService.returnVehicle(Integer.valueOf(reservationId));
    return Response.ok(reservation).build();
  }

  @Path("/acceptreturn/{reservationId}")
  @PUT
  @Produces("application/json")
  public Response acceptReturn(@PathParam("reservationId") String reservationId) {
    ReservationDto reservation = this.reservationService.acceptReturn(Integer.valueOf(reservationId));
    return Response.ok(reservation).build();
  }

}
