package dasniko.soteria;

import dasniko.soteria.entity.Account;
import dasniko.soteria.entity.AccountService;
import dasniko.soteria.entity.TokenService;
import dasniko.soteria.entity.TokenType;

import javax.inject.Inject;
import javax.security.enterprise.CallerPrincipal;
import javax.security.enterprise.credential.RememberMeCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.RememberMeIdentityStore;
import java.util.Optional;
import java.util.Set;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
public class DemoRememberMeIdentityStore implements RememberMeIdentityStore {

    @Inject
    private AccountService accountService;
    @Inject
    private TokenService tokenService;

    @Override
    public CredentialValidationResult validate(RememberMeCredential credential) {
        Optional<Account> account = accountService.getByLoginToken(credential.getToken(), TokenType.REMEMBER_ME);

        return account.map(a -> new CredentialValidationResult(new CallerPrincipal(a.getUsername())))
            .orElse(CredentialValidationResult.INVALID_RESULT);
    }

    @Override
    public String generateLoginToken(CallerPrincipal callerPrincipal, Set<String> groups) {
        return tokenService.generate(callerPrincipal.getName(), TokenType.REMEMBER_ME);
    }

    @Override
    public void removeLoginToken(String token) {
        tokenService.remove(token);
    }

}
