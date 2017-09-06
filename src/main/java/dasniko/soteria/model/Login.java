package dasniko.soteria.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Data
public class Login {
    @NotNull
    @Size(min = 3)
    @FormParam("username")
    private String username;
    @NotNull
    @Size(min = 8)
    @FormParam("password")
    private String password;
    @FormParam("rememberMe")
    private String rememberMe;

    public boolean isRememberMe() {
        return rememberMe != null && rememberMe.equals("rememberMe");
    }
}
