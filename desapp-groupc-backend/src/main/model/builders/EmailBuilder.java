package main.model.builders;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import main.model.EmailSender;

import javax.ws.rs.core.MediaType;

public class EmailBuilder {

  private Client client = Client.create();
  private String receipt = "witherwings77@gmail.com";
  private String subject = "Hello";
  private String text = "no text";

  public ClientResponse build() {
    this.client.addFilter(new HTTPBasicAuthFilter("api", "key-00b87adb4e74a7a7050d9a2be73e3bd7"));
    WebResource webResource = this.client.resource("https://api.mailgun.net/v3/sandboxe7a6b4763c4147ea9cb8a72ab84937e7.mailgun.org/messages");
    MultivaluedMapImpl formData = new MultivaluedMapImpl();
    formData.add("from", "Mailgun Sandbox <postmaster@sandboxe7a6b4763c4147ea9cb8a72ab84937e7.mailgun.org>");
    formData.add("to", this.receipt);
    formData.add("subject", this.subject);
    formData.add("text", this.text);
    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
      post(ClientResponse.class, formData);
  }

  public EmailBuilder withReceipt(String receiptEmail){
    this.receipt = receiptEmail;
    return this;
  }

  public EmailBuilder withSubject(String subject){
    this.subject = subject;
    return this;
  }

  public EmailBuilder withText(String text){
    this.text = text;
    return this;
  }

}
