package pl.web.electronics_shop.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Named

@RequestScoped
public class LogInController implements Serializable {
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;


    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest httpServletRequest =
                (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            httpServletRequest.login(username, password);
            return "autherr";
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "login_failed", null));
            return null;
        }
    }
}
