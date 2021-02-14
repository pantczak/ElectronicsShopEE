package pl.web.electronics_shop.controller;

import lombok.Getter;
import lombok.Setter;
import pl.web.electronics_shop.model.Event;
import pl.web.electronics_shop.service.EventService;
import pl.web.electronics_shop.service.ResourceService;
import pl.web.electronics_shop.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Named
@SessionScoped
public class EventController implements Serializable {

    @Inject
    @Getter
    private UserService userService;

    @Inject
    @Getter
    private ResourceService resourceService;

    @Inject
    @Getter
    private EventService eventService;

    @Getter
    @Setter
    private Event currentEvent;

    @Getter
    @Setter
    private List<Event> currentEvents;

    @Getter
    @Setter
    private Date borrowDate;

    @Getter
    @Setter
    private UUID newEventClientUuid;

    @Getter
    @Setter
    private UUID newEventDeviceUuid;


    @PostConstruct
    public void initList() {
        currentEvents = eventService.getAllEvents();
    }

    public EventController() {
        this.borrowDate = new Date();
    }

    public String returnResource(Event event) {
        eventService.returnResource(event);
        return FacesContext.getCurrentInstance().getViewRoot().getViewId() + "?faces-redirect=true";
    }

    public String deleteEvent(Event event) {
        eventService.deleteEvent(event);
        initList();
        return FacesContext.getCurrentInstance().getViewRoot().getViewId() + "?faces-redirect=true";

    }

    public String processNewEvent() {
        eventService.borrowResource(newEventDeviceUuid, newEventClientUuid);
        return "events";
    }

}
