package pl.web.electronics_shop.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Client extends User{

    @NotNull
    @Size(min = 1,max = 150)
    private int age;

    public Client(String name, String lastName, boolean isActive, String login, String password, int age) {
        super(name, lastName, isActive, login, password);
        this.age = age;
    }


}
