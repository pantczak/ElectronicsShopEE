package pl.web.electronics_shop.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID uuid;
    private int age;
    boolean isActive;
    private String name;
    private String lastName;
    private String login;
    private String password;

    public UserDto(UUID uuid, boolean isActive, String name, String lastName, String login, String password) {
        this.uuid = uuid;
        this.isActive = isActive;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }
}
