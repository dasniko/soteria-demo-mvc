package dasniko.soteria.entity;

import dasniko.soteria.SecurityException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;
import java.util.UUID;

import static dasniko.soteria.SecurityException.Reason.INVALID_USERNAME;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Stateless
public class TokenService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private AccountService accountService;

    public String generate(final String username, final TokenType tokenType) {
        String rawToken = UUID.randomUUID().toString();
        Instant expiration = Instant.now().plus(14, DAYS);

        save(rawToken, username, tokenType, expiration);

        return rawToken;
    }

    private void save(final String rawToken, final String username, final TokenType tokenType, final Instant expiration) {

        Account account = accountService.getByUsername(username)
            .orElseThrow(() -> new SecurityException(INVALID_USERNAME));

        Token token = new Token();
        token.setTokenHash(rawToken);
        token.setExpiration(expiration);
        token.setTokenType(tokenType);

        account.addToken(token);

        em.merge(account);
    }

    public void remove(String token) {
        em.createNamedQuery(Token.REMOVE_TOKEN)
            .setParameter("tokenHash", token).executeUpdate();
    }
}
