package dasniko.soteria;

import dasniko.soteria.entity.Account;
import dasniko.soteria.entity.AccountService;
import dasniko.soteria.exception.AccountNotVerifiedException;
import dasniko.soteria.exception.InvalidCredentialException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.credential.CallerOnlyCredential;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

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
                    .orElseThrow(InvalidCredentialException::new));
            }

        } catch (InvalidCredentialException e) {
            return CredentialValidationResult.INVALID_RESULT;
        }

        return CredentialValidationResult.NOT_VALIDATED_RESULT;
    }

    private CredentialValidationResult validate(Account account) {
        if (!account.isActive()) {
            throw new AccountNotVerifiedException();
        }

        return new CredentialValidationResult(account.getUsername());
    }
}
