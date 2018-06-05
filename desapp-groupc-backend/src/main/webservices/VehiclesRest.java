package main.webservices;

import main.model.Vehicle;
import main.model.dtos.VehicleDto;
import main.services.VehicleService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/vehicles")
public class VehiclesRest {

  private VehicleService vehicleService;

  public void setVehicleService(final VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @GET
  @Path("/{id}")
  @Produces("application/json")
  public Response getVehicle(@PathParam("id") String id) {
    return Response.ok(vehicleService.findById(Integer.valueOf(id))).build();
  }

  @GET
  @Path("/from/user/{id}")
  @Produces("application/json")
  public Response getVehiclesFromUser(@PathParam("id") String id) {
    List<VehicleDto> vehiclesDto = new ArrayList<>();
//      vehicleService.getVehiclesFrom(Integer.valueOf(id))
//      .stream()
//      .map(elt -> new VehicleDto(elt))
//      .collect(Collectors.toList());

    for (Vehicle vehicle: vehicleService.getVehiclesFrom(Integer.valueOf(id))) {
      vehiclesDto.add(new VehicleDto(vehicle));
    }

    return Response.ok(vehiclesDto).build();
  }

  @POST
  @Consumes("application/json")
  public Response createVehicle(VehicleDto vDto) {
    if (vehicleService.createVehicleFromDto(vDto))
      return Response.ok().build();
    else
      return Response.notModified().build();
  }

  @PUT
  @Consumes("application/json")
  public Response modifyVehicle(VehicleDto vDto) {
    if (vehicleService.updateVehicleFromDto(vDto))
      return Response.ok().build();
    else
      return Response.notModified().build();
  }

  @DELETE
  @Path("/{id}")
  public Response deleteVehicle(@PathParam("id") String id) {
    if (vehicleService.disableVehicle(Integer.valueOf(id)))
      return Response.ok().build();
    else
      return Response.notModified().build();
  }

}
