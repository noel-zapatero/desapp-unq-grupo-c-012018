package main.services;

import main.model.User;
import main.model.builders.UserBuilder;
import main.model.dtos.UserDto;
import main.repositories.UserRepository;

public class UserService extends GenericService<User> {

  private static final long serialVersionUID = -2932116622242535843L;

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
}
