package pl.web.electronics_shop.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.UUID;

@FacesConverter("UUIDConverter")
public class UuidConverter implements Converter<UUID> {
    @Override
    public UUID getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s.equals("")) {
            return null;
        }
        return UUID.fromString(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, UUID uuid) {
        if (uuid == null) {
            return null;
        }
        return uuid.toString();
    }
}
