package main.webservices;

import main.model.Publication;
import main.services.PublicationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}
