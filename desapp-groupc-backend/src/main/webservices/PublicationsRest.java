package main.webservices;

import main.model.Publication;
import main.model.dtos.PublicationDto;
import main.services.PublicationService;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/publications")
@CrossOriginResourceSharing(allowAllOrigins = true)
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
  @Path("/filter/{type}")
  @Produces("application/json")
  public Response filterPublications(@PathParam("type") String type) {
    return Response.ok(publicationService.filterByVehicleType(type)).build();
  }

  @GET
  @Path("/fromuser/{userEmail}")
  @Produces("application/json")
  public Response getPublicationsFromUser(@PathParam("userEmail") String userEmail) {
    List<PublicationDto> pubs = publicationService.getPublicationsFromUserEmailAsDto(userEmail);
    return Response.ok(pubs).build();
  }

  @GET
  @Path("/isowner/{userEmail}/{pubId}")
  public Response isOwner(@PathParam("userEmail") String userEmail, @PathParam("pubId") String pubId) {
    return Response.ok(publicationService.isOwner(userEmail, Integer.valueOf(pubId))).build();
  }

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Response createPublication(PublicationDto pDto) {
    String err = publicationService.validate(pDto);
    if (!err.equals(""))
      return Response.ok(publicationService.createPublicationFromDto(pDto)).build();
    else
      return Response.notModified(err).build();
  }

  @DELETE
  @Path("/{id}")
  public Response deletePublication(@PathParam("id") String id) {
    publicationService.deleteById(Integer.valueOf(id));
    return Response.ok().build();
  }

}
