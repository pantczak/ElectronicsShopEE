package pl.web.electronics_shop.repository.implementation;

import pl.web.electronics_shop.model.user.User;
import pl.web.electronics_shop.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class InMemoryUserRepository implements UserRepository, Serializable {
    private final List<User> users;

    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public synchronized void add(User userToAdd) {
        if (get(userToAdd.getUuid()) == null) {
            users.add(userToAdd);
        }
    }

    @Override
    public synchronized User get(UUID uuid) {
        return users.stream().filter(user -> user.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public User getByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(user.getLogin())).findFirst().orElse(null);
    }

    @Override
    public synchronized List<User> getAll() {
        return users;
    }

    @Override
    public synchronized void update(User userToUpdate) {
        users.stream().filter(user -> user.getUuid().equals(userToUpdate.getUuid())).findFirst().
                ifPresent(user -> users.set(users.indexOf(user), userToUpdate));
    }
}
