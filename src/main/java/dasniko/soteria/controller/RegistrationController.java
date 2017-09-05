package dasniko.soteria.controller;

import dasniko.soteria.model.Registration;

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
@Path("registration")
@Controller
public class RegistrationController {

    @Inject
    private Models models;

    @GET
    public String index() {
        return "registration.jsp";
    }

    @POST
    public String register(@BeanParam Registration registration) {
        models.put("name", registration.getUsername());
        return "registration_thanks.jsp";
    }
}
