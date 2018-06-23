package main.model.dtos;

import main.model.Publication;

public class PublicationDto {

  public int publicationId;
  public int vehicleOfferedId;

  /* AVAILABILITY */

  //start
  public int startYear;
  public int startMonth;
  public int startDayOfMonth;

  //end
  public int endYear;
  public int endMonth;
  public int endDayOfMonth;

  public PublicationDto() { }

  public PublicationDto(Publication publication) {
    this.setPublicationId(publication.getId());
    this.setPublicationId(publication.getVehicleOffered().getId());

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

  public int getVehicleOfferedId() {
    return vehicleOfferedId;
  }

  public void setVehicleOfferedId(int vehicleOfferedId) {
    this.vehicleOfferedId = vehicleOfferedId;
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
