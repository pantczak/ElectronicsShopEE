package pl.web.electronics_shop.model.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Admin extends User {

    public Admin(String name, String lastName, boolean isActive, String login, String password) {
        super(name, lastName, isActive, login, password);
    }
}
