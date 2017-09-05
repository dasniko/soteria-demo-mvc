package dasniko.soteria.controller;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
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

    @GET
    public String index() {
        models.put("name", "Niko");
        return "user.jsp";
    }
}
