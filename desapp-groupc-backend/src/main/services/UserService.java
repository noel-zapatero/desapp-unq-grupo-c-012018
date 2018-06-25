package main.services;

import main.model.User;
import main.model.Vehicle;
import main.model.builders.UserBuilder;
import main.model.builders.VehicleBuilder;
import main.model.dtos.UserDto;
import main.repositories.UserRepository;

public class UserService extends GenericService<User> {

  private static final long serialVersionUID = -2932116622242535843L;

  private VehicleService vehicleService;

  public void setVehicleService(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  // TODO: manejar excepciones en todos los metodos!

  public Boolean creatAndSaveFromDto(UserDto uDto) {
    this.save(uDto.toUser());
    return true;
  }

  public Boolean updateFromDto(UserDto uDto) {
    this.update(uDto.toUser());
    return true;
  }

  public User findByEmail(String email) {
    return ((UserRepository)this.getRepository()).findByEmail(email);
  }

  public User buildAndSaveFromDto(UserDto uDto) {
    User user = new UserBuilder()
      .withNameAndLastName(uDto.getFirstName(), uDto.getLastName())
      .withEmail(uDto.getEmail())
      .build();

    save(user);

    return user;
  }


  public boolean chargeCredits(String userEmail, int credits) {
    User user = findByEmail(userEmail);
    user.chargeCredits(credits);
    update(user);
    return true;
  }


  public boolean withdrawCredits(String userEmail, int credits) {
    User user = findByEmail(userEmail);
    user.whitdrawCredits(credits);
    update(user);
    return true;
  }

  // no tengo bd, creo los datos fake aca
  public User load(User user) {
    Vehicle v1 = new VehicleBuilder()
      .withBrandModel("Audi A7")
      .withContactPhone("+54 011 1234-5678")
      .withDescription("Alta nave pistera")
      .withImageUrl("https://cdn.autobild.es/sites/navi.axelspringer.es/public/styles/gallery_big/public/media/image/2017/10/nuevo-audi-a7-2018_3.jpg?itok=WAWuFJhi")
      .withPassengerAmmount(4)
      .withReturnAddresses("Roque Sáenz Peña 299, Bernal, Buenos Aires")
      .withType("Auto")
      .withWithDrawAddress("Roque Sáenz Peña 299, Bernal, Buenos Aires")
      .withZone("Bernal")
      .withOwner(user)
      .build();
    Vehicle v2 = new VehicleBuilder()
      .withBrandModel("BMW X6")
      .withContactPhone("+54 011 1234-5678")
      .withDescription("Minicamioneta chetonga")
      .withImageUrl("http://soymotor.com/sites/default/files/styles/large/public/imagenes/noticia/g-power-x6-m-typhoon-1.jpg")
      .withPassengerAmmount(6)
      .withReturnAddresses("Roque Sáenz Peña 299, Bernal, Buenos Aires")
      .withType("Auto")
      .withWithDrawAddress("Roque Sáenz Peña 299, Bernal, Buenos Aires")
      .withZone("Bernal")
      .withOwner(user)
      .build();
    Vehicle v3 = new VehicleBuilder()
      .withBrandModel("Mitsubishi Lancer Evolution")
      .withContactPhone("+54 011 1234-5678")
      .withDescription("Probablemente el auto mas tunner que exista")
      .withImageUrl("https://ag-spots-2015.o.auroraobjects.eu/2015/07/09/mitsubishi-lancer-evolution-x-c608609072015213830_1.jpg")
      .withPassengerAmmount(4)
      .withReturnAddresses("Roque Sáenz Peña 299, Bernal, Buenos Aires")
      .withType("Auto")
      .withWithDrawAddress("Roque Sáenz Peña 299, Bernal, Buenos Aires")
      .withZone("Bernal")
      .withOwner(user)
      .build();

    vehicleService.save(v1);
    vehicleService.save(v2);
    vehicleService.save(v3);

    user.addVehicle(v1);
    user.addVehicle(v2);
    user.addVehicle(v3);

    save(user);
    return user;
  }
}
