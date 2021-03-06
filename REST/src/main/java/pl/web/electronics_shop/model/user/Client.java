package pl.web.electronics_shop.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Client extends User {

    @NotNull
    @Min(1)
    @Max(150)
    private int age;

    public Client(String name, String lastName, boolean isActive, String login, String password, int age) {
        super(name, lastName, isActive, login, password);
        this.age = age;
    }

    @Override
    public String getRole() {
        return "Client";
    }
}
