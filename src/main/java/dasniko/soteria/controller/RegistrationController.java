package dasniko.soteria.controller;

import dasniko.soteria.entity.Account;
import dasniko.soteria.entity.AccountService;
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
    @Inject
    private AccountService accountService;

    @GET
    public String index() {
        return "registration.jsp";
    }

    @POST
    public String register(@BeanParam Registration registration) {

        try {
            Account account = accountService.save(registration.getUsername(),
                registration.getPassword(), registration.getEmail());
            models.put("account", account);
            return "registration_thanks.jsp";
        } catch (Exception e) {
            models.put("errors", e.getMessage());
            return index();
        }
    }
}
