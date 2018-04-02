package main.model;

import com.sun.jersey.api.client.ClientResponse;
import main.model.builders.EmailBuilder;

public class EmailSender {

  public static ClientResponse SendBookMessage(String requesterName, String receipt) {
    ClientResponse cli = new EmailBuilder()
      .withReceipt(receipt)
      .withSubject("Hello " + receipt)
      .withText(requesterName + " is trying to book your vehicle.")
      .build();
    return cli;
  }

  public static ClientResponse AcceptReservation(String receiptEmail) {
    ClientResponse cli = new EmailBuilder()
      .withReceipt(receiptEmail)
      .withText("Your request was accepted")
      .build();
    return cli;
  }

  public static ClientResponse SendPickUpMessage(String ownerEmail) {
    ClientResponse cli = new EmailBuilder()
      .withReceipt(ownerEmail)
      .withText("PickUpDone by " + ownerEmail)
      .build();
    return cli;
  }

  public static ClientResponse AcceptPickUp(String receiptEmail) {
    ClientResponse cli = new EmailBuilder()
      .withReceipt(receiptEmail)
      .withText("The pickup was accepted by the owner")
      .build();
    return cli;
  }

  public static ClientResponse SendReturnMessage(String ownerEmail) {
    ClientResponse cli = new EmailBuilder()
      .withReceipt(ownerEmail)
      .withText("Hi " + ownerEmail + ". Your vehicle has been returned")
      .build();
    return cli;
  }

  public static ClientResponse AcceptReturn(String receiptEmail) {
    ClientResponse cli = new EmailBuilder()
      .withReceipt(receiptEmail)
      .withText("Return accepted")
      .build();
    return cli;
  }
}
