package pl.web.electronics_shop.security;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AuthData {
    private String login;
    private String password;

}
