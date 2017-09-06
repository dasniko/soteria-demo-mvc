package dasniko.soteria;

import javax.ejb.ApplicationException;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@ApplicationException(rollback = true)
public class SecurityException extends RuntimeException {

    public SecurityException(Reason reason) {
        super(reason.name());
    }

    public enum Reason {
        ACCOUNT_NOT_VERIFIED,
        INVALID_CREDENTIALS,
        INVALID_PASSWORD,
        INVALID_USERNAME
    }

}
