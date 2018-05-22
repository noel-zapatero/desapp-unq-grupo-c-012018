package main.model.builders;

import main.model.Publication;
import main.model.Reservation;
import main.model.User;
import org.joda.time.DateTime;

public class ReservationBuilder {
  DateTime start = DateTime.now();
  DateTime end = DateTime.now().plusDays(1);
  User username = new UserBuilder().build();
  Publication publication = null;

  public Reservation build() {
    return new Reservation(start,end,username,publication);
  }

  public ReservationBuilder withUser(User u) {
    this.username = u;
    return this;
  }
}
