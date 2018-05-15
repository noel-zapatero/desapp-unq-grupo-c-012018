package main.model.availability;

import org.joda.time.DateTime;

import javax.persistence.Entity;

@Entity
public class NotAvailable extends AbstractAvailability implements Availability {

  public boolean isAvailable(DateTime start, DateTime end) {
    return false;
  }

}
