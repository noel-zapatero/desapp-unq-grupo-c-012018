package main.services;

import main.model.User;
import main.model.builders.UserBuilder;
import main.model.dtos.UserDto;
import org.springframework.stereotype.Service;


public class UserService extends GenericService<User> {

  private static final long serialVersionUID = -2932116622242535843L;

  private User userFromDto(UserDto uDto) {
    return new UserBuilder()
      .withEmail(uDto.getEmail())
      .withNameAndLastName(uDto.getFirstName(), uDto.getLastName())
      .withAddress(uDto.getAdress())
      .withCuil(uDto.getCuil())
      .build();
  }

  // TODO: manejar excepciones
  public Boolean creatAndSaveFromDto(UserDto uDto) {
    this.save(userFromDto(uDto));
    return true;
  }

  // TODO: manejar excepciones
  public Boolean updateFromDto(UserDto uDto) {
    this.update(userFromDto(uDto));
    return true;
  }
}
