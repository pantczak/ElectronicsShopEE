package pl.web.electronics_shop.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.Entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User extends Entity {

    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    @NotNull
    @Size(min = 2, max = 40)
    private String lastName;

    private boolean isActive = true;

    @NotNull
    @Size(min = 2, max = 20)
    private String login;

    @NotNull
    @Size(min = 8, max = 20)
    private String password;

    @Override
    public UUID getUuid() {
        return super.getUuid();
    }
}
