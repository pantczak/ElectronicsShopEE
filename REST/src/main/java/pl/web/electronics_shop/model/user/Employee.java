package pl.web.electronics_shop.model.user;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {

    public Employee(String name, String lastName, boolean isActive, String login, String password) {
        super(name, lastName, isActive, login, password);
    }

    @Override
    public String getRole() {
        return "Employee";
    }
}
