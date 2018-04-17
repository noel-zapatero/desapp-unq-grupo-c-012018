package main.webservices;

import main.model.Publication;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/publications")
public class PublicationsRest {

  @GET
  public List<Publication> getAllPublications() {
    return new ArrayList<>();
  }

}
