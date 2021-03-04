package pl.web.electronics_shop.controller;

import lombok.Getter;
import pl.web.electronics_shop.model.Event;
import pl.web.electronics_shop.model.user.User;
import pl.web.electronics_shop.service.EventService;
import pl.web.electronics_shop.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

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

    public List<Event> getUserBorrows() {
        return eventService.getEventsForClient(userService.getUserByLogin(login));
    }

    public void endBorrow(Event event){
        eventService.returnResource(event);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
