package pl.web.electronics_shop.repository;

import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.resoucre.Laptop;
import pl.web.electronics_shop.model.resoucre.Resource;
import pl.web.electronics_shop.model.resoucre.Smartphone;
import pl.web.electronics_shop.model.user.Admin;
import pl.web.electronics_shop.model.user.Client;
import pl.web.electronics_shop.model.user.Employee;
import pl.web.electronics_shop.model.user.User;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;

@Named
@ApplicationScoped
@NoArgsConstructor
public class InitRepositories implements Serializable {

    @Inject
    private ResourceRepository resourceRepository;
    @Inject
    private UserRepository userRepository;

    public void initRepo(@Observes @Initialized(ApplicationScoped.class) Object init) {
        initRepo();
    }

    private void initRepo() {
        Resource smartphone1 = new Smartphone("Samsung", "S10", true, 450, 8.5);
        Resource smartphone2 = new Smartphone("Apple", "Iphone X", true, 411, 9.5);
        Resource smartphone3 = new Smartphone("Sony", "Lumia", true, 250, 5.5);
        Resource smartphone4 = new Smartphone("Apple", "Iphone 12", true, 405, 11.5);
        Resource smartphone5 = new Smartphone("Xiaomi", "Mi 10", true, 470, 14.5);
        Resource laptop1 = new Laptop("Lenovo", "Thinkpad X230", true, 3570, 8);
        Resource laptop2 = new Laptop("HP", "Probook 15", true, 3270, 12);
        Resource laptop3 = new Laptop("Apple", "Macbook Pro 15", true, 2900, 16);
        Resource laptop4 = new Laptop("Dell", "Lattitude 13", true, 2270, 4);

        for (Resource resource : Arrays.asList(smartphone1, smartphone2, smartphone3, smartphone4,
                smartphone5, laptop1, laptop2, laptop3, laptop4)) {
            resourceRepository.add(resource);
        }

        User user1 = new Admin("Adam", "Nowak", true, "ANowak", "asdsa");
        User user2 = new Employee("Ewa", "Nowak", true, "ENowak", "asasddsa");
        User user3 = new Client("Jan", "Kowalski", true, "JKowalski", "password", 44);
        User user4 = new Client("Ada", "Nowak", true, "ANowak", "password1", 18);
        User user5 = new Client("Tomasz", "Tomczak", true, "tomtom", "tomtom123", 18);
        user5.setActive(false);

        for (User user : Arrays.asList(user1, user2,
                user3, user4, user5)) {
            userRepository.add(user);
        }
    }
}
