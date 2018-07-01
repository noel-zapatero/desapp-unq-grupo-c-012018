package main.webservices;

import main.services.AvailabilityService;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;

import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/availability")
@CrossOriginResourceSharing(allowAllOrigins = true)
public class AvailabilityRest {

  private AvailabilityService availabilityService;

  public void setAvailabilityService(final AvailabilityService aService) {
    this.availabilityService = availabilityService;
  }

}
