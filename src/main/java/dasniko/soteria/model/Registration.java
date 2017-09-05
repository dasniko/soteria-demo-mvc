package dasniko.soteria.model;

import lombok.Data;

import javax.ws.rs.FormParam;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Data
public class Registration {
    @FormParam("username")
    private String username;
    @FormParam("password")
    private String password;
    @FormParam("email")
    private String email;
}
