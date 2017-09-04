package dasniko.soteria;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@ApplicationScoped
public class StaticIdentityStore implements IdentityStore {

    private static Map<String, String> credentials;

    static {
        credentials = new HashMap<>();
        credentials.put("niko", "dasniko");
        credentials.put("john", "doe");
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            return validate((UsernamePasswordCredential) credential);
        }
        return CredentialValidationResult.NOT_VALIDATED_RESULT;
    }

    private CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        String caller = usernamePasswordCredential.getCaller();
        Password password = usernamePasswordCredential.getPassword();

        if (credentials.containsKey(caller) && password.compareTo(credentials.get(caller))) {
            return new CredentialValidationResult(caller, Collections.singleton("user"));
        }

        return CredentialValidationResult.INVALID_RESULT;
    }
}
