package main.webservices;

import main.model.dtos.PublicationDto;
import main.services.PublicationService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/publications")
public class PublicationsRest {

  private PublicationService publicationService;

  public void setPublicationService(final PublicationService publicationService) {
    this.publicationService = publicationService;
  }

  @GET
  @Produces("application/json")
  public Response getAllPublications() {
    return Response.ok(publicationService.retriveAllDtos()).build();
  }

  @GET
  @Path("/{id}")
  @Produces("application/json")
  public Response getPublicationById(@PathParam("id") String id) {
    return Response.ok(new PublicationDto(publicationService.findById(Integer.valueOf(id)))).build();
  }

  @GET
  @Path("/fromuser/{userEmail}")
  @Produces("application/json")
  public Response getPublicationsFromUser(@PathParam("userEmail") String userEmail) {
    return Response.ok(publicationService.getPublicationsFromUserEmailAsDto(userEmail)).build();
  }

  @POST
  @Consumes("application/json")
  public Response createPublication(PublicationDto pDto) {
    publicationService.createPublicationFromDto(pDto);
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  public Response deletePublication(@PathParam("id") String id) {
    publicationService.deleteById(Integer.valueOf(id));
    return Response.ok().build();
  }

}
