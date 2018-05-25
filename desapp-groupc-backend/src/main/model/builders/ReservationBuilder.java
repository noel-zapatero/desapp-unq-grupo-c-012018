package main.model.builders;

import main.model.Publication;
import main.model.Reservation;
import main.model.User;
import org.joda.time.DateTime;

public class ReservationBuilder {
  DateTime start = DateTime.now();
  DateTime end = DateTime.now().plusDays(1);
  User user;
  Publication publication;

  public Reservation build() {
    Reservation r = new Reservation();

    r.setStart(start);
    r.setEnd(end);
    r.setUser(user);
    r.setPublication(publication);

    return r;
  }

  public ReservationBuilder withUser(User u) {
    this.user = u;
    return this;
  }

  public ReservationBuilder withStartDate(DateTime start) {
    this.start = start;
    return this;
  }

  public ReservationBuilder withEndDate(DateTime end) {
    this.end = end;
    return this;
  }

  public ReservationBuilder withPublication(Publication p) {
    this.publication = publication;
    return this;
  }
}
