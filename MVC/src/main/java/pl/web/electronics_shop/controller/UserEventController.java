package pl.web.electronics_shop.controller;

import lombok.Getter;
import pl.web.electronics_shop.model.resoucre.Resource;
import pl.web.electronics_shop.service.EventService;
import pl.web.electronics_shop.service.ResourceService;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class UserEventController implements Serializable {
    @Getter
    private List<Resource> availableResources;

    @Inject
    private HttpServletRequest request;

    @Inject
    private EventService eventService;

    @Inject
    private ResourceService resourceService;

    private String currentUserLogin;

    @PostConstruct
    public void init() {
        availableResources = resourceService.getAllAvailableResources();
        currentUserLogin = request.getRemoteUser();
    }

    public void borrowResource(Resource resource) {
        eventService.borrowResourceByLogin(resource.getUuid(), currentUserLogin);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            init();
        }
    }

    public void updateResourceList() {
        init();
    }
}
