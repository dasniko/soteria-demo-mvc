package dasniko.soteria.model;

import lombok.Data;

import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Data
public class Login {
    @Size(min = 1, message = "Please enter a valid username.")
    @FormParam("username")
    private String username;
    @Size(min = 1, message = "Please enter a valid password.")
    @FormParam("password")
    private String password;
    @FormParam("rememberMe")
    private String rememberMe;

    public boolean isRememberMe() {
        return rememberMe != null && rememberMe.equals("rememberMe");
    }
}
