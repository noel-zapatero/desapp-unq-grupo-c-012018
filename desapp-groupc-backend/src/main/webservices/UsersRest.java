package main.webservices;

import main.model.User;
import main.model.dtos.UserDto;
import main.services.UserService;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/users")
@CrossOriginResourceSharing(allowAllOrigins = true)
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
  @Path("chargecredits/{userEmail}/{credits}")
  public Response chargeCredits(
    @PathParam("userEmail") String userEmail,
    @PathParam("credits") String credits)
  {
    userService.chargeCredits(userEmail, Integer.valueOf(credits));
    return Response.ok(userService.creditsOf(userEmail)).build();
  }

  @PUT
  @Path("withdrawcredits/{userEmail}/{credits}")
  public Response withdrawCredits(
    @PathParam("userEmail") String userEmail,
    @PathParam("credits") String credits)
  {
    userService.withdrawCredits(userEmail, Integer.valueOf(credits));
    return Response.ok(userService.creditsOf(userEmail)).build();
  }

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Response userLogIn(UserDto uDto) {
    User retrievedUser = userService.findByEmail(uDto.getEmail());

    if (retrievedUser == null)
      retrievedUser = userService.buildAndSaveFromDto(uDto);

//    retrievedUser = userService.load(retrievedUser);

    return Response.ok(new UserDto(retrievedUser)).build();
  }

}
