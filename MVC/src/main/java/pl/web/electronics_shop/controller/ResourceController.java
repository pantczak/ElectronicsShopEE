package pl.web.electronics_shop.controller;

import lombok.Getter;
import lombok.Setter;
import pl.web.electronics_shop.model.resoucre.Laptop;
import pl.web.electronics_shop.model.resoucre.Smartphone;
import pl.web.electronics_shop.service.ResourceService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ResourceController implements Serializable {
    @Inject
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
}
