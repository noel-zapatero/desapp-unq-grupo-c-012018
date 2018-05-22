package test;

import main.model.Carpnd;
import main.model.Publication;
import main.model.User;
import main.model.builders.PublicationBuilder;
import main.model.builders.UserBuilder;
import org.junit.Ignore;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class TestUser {

  @Test
  public void testCreateUser(){
        User burns = new UserBuilder()
                .withNameAndLastName("Montgomery", "Burns")
                .withAddress("Fake Street 123")
                .withEmail("mburns@springfield.com")
                .build();

        assertTrue(burns.getName().equals("Montgomery"));
    }

  @Test
    public void testChargeAndWithdrawCredits(){
        User newUser = new UserBuilder().build();

        newUser.chargeCredits(100);
        assertTrue(newUser.getCredits() == 100);
        newUser.whitdrawCredits(25);
        assertTrue(newUser.getCredits() == 75);
    }

  @Test
    public void testReceiveRating(){
        User newUser = new UserBuilder().build();

        assertTrue(newUser.getRating() == 0);
        newUser.receiveRating(5);
        assertTrue(newUser.getRating() == 5);
        newUser.receiveRating(3);
        assertTrue(newUser.getRating() == 4);
        newUser.receiveRating(3);
        assertTrue(newUser.getRating() == 3.67);
    }

  @Test
    public void testEmails(){
      Carpnd carpnd = new Carpnd();

      User newUser = new UserBuilder()
        .withEmail("witherwings77@gmail.com")
        .withNameAndLastName("Noel", "Zapatero")
        .build();

      Publication pub = new PublicationBuilder()
        .withVehicle(newUser.myVehicles.get(0))
        .withOwner(newUser)
        .build();

      //Se utiliza solo un mismo usuario y mail para testear la salida y llegada de los mismos
      carpnd.bookVehicle(newUser.getName(),pub);
      carpnd.acceptReservation(pub.getOwnerEmail());
      carpnd.pickUpDone(pub);
      carpnd.acceptPickUp(pub.getOwnerEmail());
      carpnd.returnDone(pub,5);
      carpnd.acceptReturn(pub.getOwnerEmail(),newUser,5);
    }

}
