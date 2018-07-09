package main.model;

import main.model.dtos.PublicationDto;
import main.model.exceptions.AvailabilityException;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
public class Availability {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int availabilityId;

  @Column
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  private DateTime start;

  @Column
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  private DateTime end;

  public Availability() { }

  public Availability(DateTime start, DateTime end) {
    this.start = start;
    this.end = end;
  }

  public boolean isAvailable(DateTime start, DateTime end) {
    return this.isBeforeOrAtTheSameTime(start) && this.end.plusMinutes(1).isAfter(end);
  }

  private boolean isAfter(DateTime start, DateTime end) {
    return start.isAfter(this.end);
  }

  private boolean isBefore(DateTime start, DateTime end) {
    return end.isBefore(this.start);
  }

  private boolean isBeforeOrAtTheSameTime(DateTime dateTime) {
    return this.start.isBefore(dateTime.plusMinutes(1));
  }

  public DateTime getStart() {
    return start;
  }

  public DateTime getEnd() {
    return end;
  }

  public static Availability FromPublicationDto(PublicationDto pDto) {
    DateTime from = new DateTime(
      pDto.getStartYear(),
      pDto.getStartMonth(),
      pDto.getStartDayOfMonth(),
      1,
      1
    );
    DateTime to = new DateTime(
      pDto.getEndYear(),
      pDto.getEndMonth(),
      pDto.getEndDayOfMonth(),
      1,
      1
    );
    return new Availability(from, to);
  }
}
