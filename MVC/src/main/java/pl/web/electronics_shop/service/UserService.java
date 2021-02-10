package pl.web.electronics_shop.service;

import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.user.Admin;
import pl.web.electronics_shop.model.user.Client;
import pl.web.electronics_shop.model.user.Employee;
import pl.web.electronics_shop.model.user.User;
import pl.web.electronics_shop.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Named
@RequestScoped
@NoArgsConstructor
public class UserService implements Serializable {

    @Inject
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public List<Client> getAllClients() {
        return userRepository.getAll().stream().filter(user -> user instanceof Client).
                map(user -> (Client) user).collect(Collectors.toList());
    }

    public List<Admin> getAllAdmins() {
        return userRepository.getAll().stream().filter(user -> user instanceof Admin).
                map(user -> (Admin) user).collect(Collectors.toList());
    }

    public List<Employee> getAllEmployees() {
        return userRepository.getAll().stream().filter(user -> user instanceof Employee).
                map(user -> (Employee) user).collect(Collectors.toList());
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
