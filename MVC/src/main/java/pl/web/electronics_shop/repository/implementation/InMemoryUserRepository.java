package pl.web.electronics_shop.repository.implementation;

import pl.web.electronics_shop.model.user.User;
import pl.web.electronics_shop.repository.UserRepository;

import java.util.List;
import java.util.UUID;

public class InMemoryUserRepository implements UserRepository {
    private List<User> users;

    @Override
    public synchronized void add(User user) {

    }

    @Override
    public synchronized User get(UUID uuid) {
        return users.stream().filter(user -> user.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public synchronized List<User> getAll() {
        return List.copyOf(users);
    }

    @Override
    public synchronized void update(User user) {


    }

    @Override
    public synchronized void delete(User user) {

    }
}
