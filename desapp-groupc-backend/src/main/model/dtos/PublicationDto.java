package main.model.dtos;

import main.model.Publication;

public class PublicationDto {

  private int publicationId;
  private VehicleDto vehicleOffered;

  /* AVAILABILITY */

  //start
  private int startYear;
  private int startMonth;
  private int startDayOfMonth;

  //end
  private int endYear;
  private int endMonth;
  private int endDayOfMonth;

  public PublicationDto(Publication publication) {
    this.setPublicationId(publication.getId());
    this.setVehicleOffered(new VehicleDto(publication.getVehicleOffered()));

    this.setStartDayOfMonth(publication.getAvailability().getStart().getDayOfMonth());
    this.setStartMonth(publication.getAvailability().getStart().getMonthOfYear());
    this.setStartYear(publication.getAvailability().getStart().getYear());

    this.setEndDayOfMonth(publication.getAvailability().getEnd().getDayOfMonth());
    this.setEndMonth(publication.getAvailability().getEnd().getMonthOfYear());
    this.setEndYear(publication.getAvailability().getEnd().getYear());
  }

  public int getPublicationId() {
    return publicationId;
  }

  public void setPublicationId(int publicationId) {
    this.publicationId = publicationId;
  }

  public VehicleDto getVehicleOffered() {
    return vehicleOffered;
  }

  public void setVehicleOffered(VehicleDto vehicleOffered) {
    this.vehicleOffered = vehicleOffered;
  }

  public int getStartYear() {
    return startYear;
  }

  public void setStartYear(int startYear) {
    this.startYear = startYear;
  }

  public int getStartMonth() {
    return startMonth;
  }

  public void setStartMonth(int startMonth) {
    this.startMonth = startMonth;
  }

  public int getStartDayOfMonth() {
    return startDayOfMonth;
  }

  public void setStartDayOfMonth(int startDayOfMonth) {
    this.startDayOfMonth = startDayOfMonth;
  }

  public int getEndYear() {
    return endYear;
  }

  public void setEndYear(int endYear) {
    this.endYear = endYear;
  }

  public int getEndMonth() {
    return endMonth;
  }

  public void setEndMonth(int endMonth) {
    this.endMonth = endMonth;
  }

  public int getEndDayOfMonth() {
    return endDayOfMonth;
  }

  public void setEndDayOfMonth(int endDayOfMonth) {
    this.endDayOfMonth = endDayOfMonth;
  }
}
