package main.webservices;

import main.model.User;
import main.model.dtos.CreditsOperationDto;
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

  @GET
  @Path("/byemail/{email}")
  @Produces("application/json")
  public Response findUserByEmail(@PathParam("email") String email) {
    return Response.ok(new UserDto(userService.findByEmail(email))).build();
  }

  @PUT
  @Consumes("application/json")
  public Response updateUser(UserDto uDto) {
    if (userService.updateFromDto(uDto))
      return Response.ok().build();
    else
      return Response.notModified().build();
  }

  @PUT
  @Path("/chargecredits")
  public Response chargeCredits(CreditsOperationDto op) {
    userService.chargeCredits(op.getUserEmail(), op.getCredits());
    return Response.ok().build();
  }

  @PUT
  @Path("/withdrawcredits")
  public Response withdrawCredits(CreditsOperationDto op) {
    userService.withdrawCredits(op.getUserEmail(), op.getCredits());
    return Response.ok().build();
  }

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Response userLogIn(UserDto uDto) {
    User retrievedUser = userService.findByEmail(uDto.getEmail());

    if (retrievedUser == null)
      retrievedUser = userService.buildAndSaveFromDto(uDto);

    return Response.ok(new UserDto(retrievedUser)).build();
  }

}
