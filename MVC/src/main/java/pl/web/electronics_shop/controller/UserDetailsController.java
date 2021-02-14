package pl.web.electronics_shop.controller;

import lombok.Getter;
import pl.web.electronics_shop.model.user.User;
import pl.web.electronics_shop.service.EventService;
import pl.web.electronics_shop.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Named
@ViewScoped
public class UserDetailsController implements Serializable {
    @Inject
    HttpServletRequest request;

    @Inject
    private UserService userService;
    @Inject
    private EventService eventService;

    @Getter
    private String login;

    @Getter
    private User userForDetails;

    @PostConstruct
    public void init() {
        login = request.getRemoteUser();
        userForDetails = userService.getUserByLogin(login);
    }

}
