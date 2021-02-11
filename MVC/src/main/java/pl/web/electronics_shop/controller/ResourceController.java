package pl.web.electronics_shop.controller;

import lombok.Getter;
import lombok.Setter;
import pl.web.electronics_shop.model.resoucre.Laptop;
import pl.web.electronics_shop.model.resoucre.Resource;
import pl.web.electronics_shop.model.resoucre.Smartphone;
import pl.web.electronics_shop.service.ResourceService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

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

    public ResourceController() {
        newLaptop = new Laptop();
        newSmartphone = new Smartphone();
    }

    public String editResource(Resource resource) {
        if (resource instanceof Laptop) {
            currentLaptop = (Laptop) resource;
            return "laptop";
        }
        currentSmartphone = (Smartphone) resource;
        return "smartphone";
    }

    public void deleteResource(Resource resource) {
        resourceService.deleteResource(resource);
    }
}
