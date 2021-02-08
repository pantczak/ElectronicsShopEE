package pl.web.electronics_shop.service;

import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.user.Client;
import pl.web.electronics_shop.model.user.User;
import pl.web.electronics_shop.repository.implementation.InMemoryUserRepository;
import pl.web.electronics_shop.service.dto.UserDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
@NoArgsConstructor
public class UserService {

    @Inject
    InMemoryUserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.getAll().stream().map(this::map).collect(Collectors.toList());
    }

    public void addUser(UserDto userDto) {
        if (userRepository.get(userDto.getUuid()) == null) {
            userRepository.add(mapBack(userDto));
        } else {
            userRepository.update(mapBack(userDto));
        }

    }

    private User mapBack(UserDto userDto) {
        //TODO change or implement (problem when mapping DTO to User/Client/Employee/Admin)
        return null;
    }

    private UserDto map(User user) {
        if (user == null) {
            return new UserDto();
        }
        if (user instanceof Client) {
            return new UserDto(user.getUuid(), ((Client) user).getAge(), user.isActive(), user.getName(), user.getLastName(), user.getLogin(), user.getPassword());
        }
        return new UserDto(user.getUuid(), user.isActive(), user.getName(), user.getLastName(), user.getLogin(), user.getPassword());
    }


}
