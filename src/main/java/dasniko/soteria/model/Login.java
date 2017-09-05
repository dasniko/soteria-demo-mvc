package dasniko.soteria.model;

import lombok.Data;

import javax.ws.rs.FormParam;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Data
public class Login {
    @FormParam("username")
    private String username;
    @FormParam("password")
    private String password;
    @FormParam("rememberMe")
    private String rememberMe;

    public boolean isRememberMe() {
        return rememberMe != null && rememberMe.equals("rememberMe");
    }
}
