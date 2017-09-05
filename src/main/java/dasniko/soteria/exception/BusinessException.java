package dasniko.soteria.exception;

import javax.ejb.ApplicationException;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@ApplicationException(rollback = true)
public class BusinessException extends RuntimeException {
}
