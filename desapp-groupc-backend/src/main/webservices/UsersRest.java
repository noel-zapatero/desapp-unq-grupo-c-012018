package main.webservices;

import main.model.dtos.UserDto;
import main.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/users")
public class UsersRest {

  private UserService uService;

  @GET
  @Path("/{id}")
  @Produces("application/json")
  public Response getUser(@PathParam("id") String id) {
    return Response.ok(new UserDto(uService.findById(Integer.valueOf(id)))).build();
  }

  @POST
  @Consumes("application/json")
  public Response createUser(UserDto uDto) {
    if (uService.creatAndSaveFromDto(uDto))
      return Response.ok().build();
    else
      return Response.notModified().build();
  }

  @PUT
  @Consumes("application/json")
  public Response modifyUser(UserDto uDto) {
    if (uService.updateFromDto(uDto))
      return Response.ok().build();
    else
      return Response.notModified().build();
  }

}
