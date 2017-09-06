package dasniko.soteria;

import dasniko.soteria.entity.Account;
import dasniko.soteria.entity.AccountService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.credential.CallerOnlyCredential;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

import static dasniko.soteria.SecurityException.Reason.ACCOUNT_NOT_VERIFIED;
import static dasniko.soteria.SecurityException.Reason.INVALID_CREDENTIALS;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@ApplicationScoped
public class DemoIdentityStore implements IdentityStore {

    @Inject
    private AccountService accountService;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        try {

            if (credential instanceof UsernamePasswordCredential) {
                String username = ((UsernamePasswordCredential) credential).getCaller();
                String password = ((UsernamePasswordCredential) credential).getPasswordAsString();

                return validate(accountService.getByUsernameAndPassword(username, password));
            }

            if (credential instanceof CallerOnlyCredential) {
                String username = ((CallerOnlyCredential) credential).getCaller();

                return validate(accountService.getByUsername(username)
                    .orElseThrow(() -> new SecurityException(INVALID_CREDENTIALS)));
            }

        } catch (SecurityException e) {
            return CredentialValidationResult.INVALID_RESULT;
        }

        return CredentialValidationResult.NOT_VALIDATED_RESULT;
    }

    private CredentialValidationResult validate(Account account) {
        if (!account.isActive()) {
            throw new SecurityException(ACCOUNT_NOT_VERIFIED);
        }

        return new CredentialValidationResult(account.getUsername());
    }
}
