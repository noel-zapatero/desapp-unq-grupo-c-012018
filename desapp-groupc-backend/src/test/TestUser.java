package test;

import junit.framework.TestCase;
import main.model.Carpnd;
import main.model.Publication;
import main.model.User;
import main.model.Vehicle;
import main.model.builders.PublicationBuilder;
import main.model.builders.UserBuilder;

public class TestUser extends TestCase {

    public void testCreateUser(){
        User burns = new UserBuilder()
                .withCuil(30000000011L)
                .withNameAndLastName("Montgomery", "Burns")
                .withAddress("Fake Street 123")
                .withEmail("mburns@springfield.com")
                .build();

        assert(burns.getName()).equals("Montgomery");
    }

    public void testCreateVehicleFromUser(){
      User newUser = new UserBuilder().build();

      newUser.createVehicle();
      assertTrue(newUser.myVehicles.size() == 1);
    }

    public void testChargeAndWithdrawCredits(){
        User newUser = new UserBuilder().build();

        newUser.chargeCredits(100);
        assertTrue(newUser.getCredits() == 100);
        newUser.whitdrawCredits(25);
        assertTrue(newUser.getCredits() == 75);
    }

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

    public void testEmails(){
      User newUser = new UserBuilder()
        .withEmail("witherwings77@gmail.com")
        .withNameAndLastName("Noel", "Zapatero")
        .build();
      Publication pub = new PublicationBuilder()
        .withVehicle(new Vehicle())
        .withOwner(newUser)
        .build();

      //Se utiliza solo un mismo usuario y mail para testear la salida y llegada de los mismos
      newUser.bookVehicle(pub);
      newUser.acceptReservation(pub.getOwnerEmail());
      newUser.pickUpDone(pub);
      newUser.acceptPickUp(pub.getOwnerEmail());
      newUser.returnDone(pub,5);
      newUser.acceptReturn(pub.getOwnerEmail(),newUser,5);
    }

}
