package dasniko.soteria.controller;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.security.enterprise.SecurityContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Path("user")
@Controller
public class UserController {

    @Inject
    private Models models;
    @Inject
    private SecurityContext securityContext;

    @GET
    public String index() {
        models.put("name", securityContext.getCallerPrincipal().getName());
        return "user.jsp";
    }
}
