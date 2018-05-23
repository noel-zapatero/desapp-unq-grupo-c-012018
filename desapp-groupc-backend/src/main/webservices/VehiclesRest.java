package main.webservices;

import main.model.Vehicle;
import main.model.dtos.VehicleDto;
import main.services.VehicleService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/vehicles")
public class VehiclesRest {

  private VehicleService vService;

  @GET
  @Path("/{id}")
  @Produces("application/json")
  public Response getVehicle(@PathParam("id") String id) {
    return Response.ok(vService.findById(Integer.valueOf(id))).build();
  }

  @POST
  @Consumes("application/json")
  public Response createVehicle(VehicleDto vDto) {
    if (vService.createVehicle(vDto.toVehicle()))
      return Response.ok().build();
    else
      return Response.notModified().build();
  }

  @PUT
  @Consumes("application/json")
  public Response modifyVehicle(VehicleDto vDto) {
    if (vService.updateVehicle(vDto.toVehicle()))
      return Response.ok().build();
    else
      return Response.notModified().build();
  }

  @DELETE
  @Path("/{id}")
  public Response deleteVehicle(@PathParam("id") String id) {
    if (vService.disableVehicle(Integer.valueOf(id)))
      return Response.ok().build();
    else
      return Response.notModified().build();
  }

}
