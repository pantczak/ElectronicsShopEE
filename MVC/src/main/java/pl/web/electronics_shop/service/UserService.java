package pl.web.electronics_shop.service;

import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.user.User;
import pl.web.electronics_shop.repository.UserRepository;
import pl.web.electronics_shop.repository.implementation.InMemoryUserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@RequestScoped
@NoArgsConstructor
public class UserService implements Serializable {

    @Inject
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public void addUser(User user) {
        if (user != null) {
            userRepository.add(user);
        }
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public void changeActiveStatus(User user) {
        userRepository.get(user.getUuid()).setActive(!user.isActive());
    }

    public User getUserByUuid(UUID uuid) {
        return userRepository.get(uuid);
    }

    public User getUserByLogin(String login) {
        return userRepository.getByLogin(login);
    }


}
