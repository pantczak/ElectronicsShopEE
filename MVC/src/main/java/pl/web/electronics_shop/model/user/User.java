package pl.web.electronics_shop.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.web.electronics_shop.model.Entity;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User extends Entity {
    private String name;
    private String lastName;
    private boolean isActive = true;
    private String login;
    private String password;

    @Override
    public UUID getUuid() {
        return super.getUuid();
    }
}
