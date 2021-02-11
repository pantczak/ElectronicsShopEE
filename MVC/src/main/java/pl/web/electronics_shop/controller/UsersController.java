package pl.web.electronics_shop.controller;

import lombok.Getter;
import lombok.Setter;
import pl.web.electronics_shop.model.user.Admin;
import pl.web.electronics_shop.model.user.Client;
import pl.web.electronics_shop.model.user.Employee;
import pl.web.electronics_shop.model.user.User;
import pl.web.electronics_shop.service.UserService;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.UUID;

@Named
@SessionScoped
public class UsersController implements Serializable {
    @Inject
    @Getter
    private UserService userService;

    @Getter
    @Setter
    private Client currentClient;
    @Getter
    @Setter
    private User currentUser;
    @Getter
    @Setter
    private Client newClient;
    @Getter
    @Setter
    private Employee newEmployee;
    @Getter
    @Setter
    private Admin newAdministrator;
    @Getter
    @Setter
    private UUID userId;
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String userTableType;

    public UsersController() {
        this.newAdministrator = new Admin();
        this.newClient = new Client();
        this.newEmployee = new Employee();
    }

    public String changeActiveStatus(User user) {
        user.setActive(!user.isActive());
        return FacesContext.getCurrentInstance().getViewRoot().getViewId() + "?faces-redirect=true";
    }

    public String editUser(User user) {
        if (user instanceof Client) {
            currentClient = (Client) user;
            return "client";
        }
        currentUser = user;
        return "user";
    }

    public String processUpdatedUser() {
        return "main";
    }


    public String processNewClient() {
        userService.addUser(newClient);
        return "clients";
    }

    public String processNewEmployee() {
        userService.addUser(newEmployee);
        return "employees";
    }

    public String processNewAdmin() {
        userService.addUser(newAdministrator);
        return "admins";
    }
}
