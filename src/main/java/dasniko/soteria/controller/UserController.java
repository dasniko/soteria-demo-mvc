package dasniko.soteria.controller;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.security.enterprise.SecurityContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

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

    @GET
    @Path("logout")
    public String logout(@Context HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:user";
    }
}
