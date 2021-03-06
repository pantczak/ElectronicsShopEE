package pl.web.electronics_shop.rest;

import pl.web.electronics_shop.security.AuthData;
import pl.web.electronics_shop.security.JWTCreatorVerifier;

import javax.inject.Inject;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)

@Path("/auth")
public class AuthResource {
    @Inject
    private IdentityStoreHandler identityStoreHandler;

    @POST
    public Response logIn(AuthData loginData) {
        Credential credential = new UsernamePasswordCredential(loginData.getLogin(),
                new Password(loginData.getPassword()));
        CredentialValidationResult result = identityStoreHandler.validate(credential);
        if (result.getStatus() == CredentialValidationResult.Status.VALID) {
            return Response.status(202)
                    .type("application/jwt")
                    .entity(JWTCreatorVerifier.createJWTString(result))
                    .build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

}
