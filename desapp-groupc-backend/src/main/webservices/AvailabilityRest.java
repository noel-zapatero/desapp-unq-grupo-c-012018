package main.webservices;

import main.services.AvailabilityService;

import javax.ws.rs.Path;

@Path("/availability")
public class AvailabilityRest {

  private AvailabilityService availabilityService;

  public void setAvailabilityService(final AvailabilityService aService) {
    this.availabilityService = availabilityService;
  }

}
