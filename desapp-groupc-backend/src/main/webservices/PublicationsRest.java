package main.webservices;

import main.model.Publication;
import main.services.PublicationService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/publications")
public class PublicationsRest {

  private PublicationService publicationService;

  public void setPublicationService(final PublicationService publicationService) {
    this.publicationService = publicationService;
  }

  @GET
  @Produces("application/json")
  public List<Publication> getAllPublications() {
    return new ArrayList<Publication>();
  }

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  @Path("/pub/{id}")
  public Response createPublication(@PathParam("id") String id) {
    return Response.ok(PublicationService.createPublication(id));
  }
}
