package main.webservices;

import main.model.dtos.UserDto;
import main.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/users")
public class UsersRest {

  private UserService userService;

  public void setUserService(final UserService userService) {
    this.userService = userService;
  }

  @GET
  @Path("/{id}")
  @Produces("application/json")
  public Response getUser(@PathParam("id") String id) {
    return Response.ok(new UserDto(userService.findById(Integer.valueOf(id)))).build();
  }

  @POST
  @Consumes("application/json")
  public Response updateUser(UserDto uDto) {
    if (userService.updateFromDto(uDto))
      return Response.ok().build();
    else
      return Response.notModified().build();
  }

  @PUT
  @Consumes("application/json")
  public Response createUser(UserDto uDto) {
    if (userService.creatAndSaveFromDto(uDto))
      return Response.ok().build();
    else
      return Response.notModified().build();
  }

}
