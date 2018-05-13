package main.webservices;

import main.model.dtos.UserDto;
import main.services.UserService;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@Path("/users")
public class UsersRest {

  private UserService uService;

  @GET
  @Path("/{id}")
  @Produces("application/json")
  public Response getUser(@PathParam("id") String id) {
    return Response.ok(uService.findById(Integer.valueOf(id))).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public String createUser(String json) {
    return json;
  }

}
