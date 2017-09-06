package dasniko.soteria.controller;

import dasniko.soteria.entity.Account;
import dasniko.soteria.entity.AccountService;
import dasniko.soteria.model.Registration;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.binding.BindingResult;
import javax.mvc.binding.ValidationError;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

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
    @Inject
    private BindingResult bindingResult;

    @GET
    public String index() {
        return "registration.jsp";
    }

    @POST
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String register(@Valid @BeanParam Registration registration) {
        if (bindingResult.isFailed()) {
            List<String> errors = bindingResult.getAllValidationErrors().stream()
                .map(ValidationError::getMessage)
                .collect(Collectors.toList());
            models.put("errors", errors);
            return index();
        }

        try {
            Account account = accountService.save(registration.getUsername(),
                registration.getPassword(), registration.getEmail());
            models.put("account", account);
            return "registration_thanks.jsp";
        } catch (Exception e) {
            models.put("errors", getRootCause(e).getMessage());
            return index();
        }
    }

    private Throwable getRootCause(Throwable e) {
        Throwable cause;
        Throwable result = e;
        while(null != (cause = result.getCause())  && (result != cause) ) {
            result = cause;
        }
        return result;
    }
}
