package dasniko.soteria.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Data
public class Registration {
    @NotNull
    @Size(min = 3, max = 255)
    @FormParam("username")
    private String username;
    @NotNull
    @Size(min = 8, max = 255)
    @FormParam("password")
    private String password;
    @NotNull
    @Size(min = 8, max = 255)
    @FormParam("email")
    private String email;
}
