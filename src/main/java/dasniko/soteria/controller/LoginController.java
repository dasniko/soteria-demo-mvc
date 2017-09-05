package dasniko.soteria.controller;

import dasniko.soteria.model.Login;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Path("login")
@Controller
public class LoginController {

    @Inject
    private Models models;

    @GET
    public String index() {
        return "login.jsp";
    }

    @POST
    public String login(@BeanParam Login login) {

        return "login";
    }
}
