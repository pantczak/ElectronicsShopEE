package pl.web.electronics_shop.controller;

import pl.web.electronics_shop.model.resoucre.Resource;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class UserEventController implements Serializable {
    private List<Resource> availableDevices;

    @Inject
    private HttpServletRequest request;


//    TODO FINISH
}
