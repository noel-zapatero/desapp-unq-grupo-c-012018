package main.webservices;

import main.services.AvailabilityService;

import javax.ws.rs.Path;

@Path("/availability")
public class AvailabilityRest {

  private AvailabilityService aService;

  public void setAvailabilityService(final AvailabilityService aService) {
    this.aService = aService;
  }

}
