package main.model.availability;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
public class Available extends AbstractAvailability implements Availability {

  @Column
  @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
  private DateTime start;

  @Column
  @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
  private DateTime end;


  public Available(DateTime start, DateTime end) {
    this.start = start;
    this.end = end;
  }

  public boolean isAvailable(DateTime start, DateTime end) {
    if (this.start == null || this.end == null) //TODO: refactorizar esta villereada!!
      return false;

    return this.isBeforeOrAtTheSameTime(start) && this.end.plusMinutes(1).isAfter(end);
  }

  private boolean isBeforeOrAtTheSameTime(DateTime dateTime) {
    return this.start.isBefore(dateTime.plusMinutes(1));
  }
}
