package main.model.availability;

import org.joda.time.DateTime;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface Availability {

  public boolean isAvailable(DateTime start, DateTime end);

}
