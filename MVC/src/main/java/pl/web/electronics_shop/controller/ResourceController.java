package pl.web.electronics_shop.controller;

import lombok.Getter;
import lombok.Setter;
import pl.web.electronics_shop.model.resoucre.Laptop;
import pl.web.electronics_shop.model.resoucre.Resource;
import pl.web.electronics_shop.model.resoucre.Smartphone;
import pl.web.electronics_shop.service.ResourceService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ResourceController implements Serializable {
    @Inject
    @Getter
    private ResourceService resourceService;

    @Getter
    @Setter
    private Laptop newLaptop;
    @Getter
    @Setter
    private Smartphone newSmartphone;
    @Getter
    @Setter
    private Laptop currentLaptop;
    @Getter
    @Setter
    private Smartphone currentSmartphone;
    @Getter
    @Setter
    private List<Laptop> currentLaptops;
    @Getter
    @Setter
    private List<Smartphone> currentSmartphones;

    public ResourceController() {
        newLaptop = new Laptop();
        newSmartphone = new Smartphone();
    }

    @PostConstruct
    public void initList() {
        currentLaptops = resourceService.getAllLaptops();
        currentSmartphones = resourceService.getAllSmartphones();

    }

    public String editResource(Resource resource) {
        if (resource instanceof Laptop) {
            currentLaptop = (Laptop) resource;
            return "laptop";
        }
        currentSmartphone = (Smartphone) resource;
        return "smartphone";
    }

    public String deleteResource(Resource resource) {
        resourceService.deleteResource(resource);
        initList();
        return FacesContext.getCurrentInstance().getViewRoot().getViewId() + "?faces-redirect=true";
    }

    public String processUpdatedResource() {
        return "main";
    }

    public String processNewLaptop() {
        resourceService.addResource(newLaptop);
        return "laptops";
    }

    public String processNewSmartphone() {
        resourceService.addResource(newSmartphone);
        return "smartphones";
    }
}
