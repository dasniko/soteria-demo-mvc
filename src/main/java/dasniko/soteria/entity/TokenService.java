package dasniko.soteria.entity;

import dasniko.soteria.exception.InvalidUsernameException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Stateless
public class TokenService {

    @PersistenceContext
    EntityManager em;

    @Inject
    AccountService accountService;

    public String generate(final String username, final String ipAddress,
                           final String description, final TokenType tokenType) {
        String rawToken = UUID.randomUUID().toString();
        Instant expiration = Instant.now().plus(14, DAYS);

        save(rawToken, username, ipAddress, description, tokenType, expiration);

        return rawToken;
    }

    public void save(final String rawToken, final String username, final String ipAddress,
                     final String description, final TokenType tokenType, final Instant expiration) {

        Account account = accountService.getByUsername(username).orElseThrow(InvalidUsernameException::new);

        Token token = new Token();
        token.setTokenHash(rawToken);
        token.setExpiration(expiration);
        token.setDescription(description);
        token.setTokenType(tokenType);
        token.setIpAddress(ipAddress);

        account.addToken(token);

        em.merge(account);
    }

    public void remove(String token) {
        em.createNamedQuery(Token.REMOVE_TOKEN, Token.class)
            .setParameter("tokenHash", token).executeUpdate();
    }

    public void removeExpired() {
        em.createNamedQuery(Token.REMOVE_EXPIRED_TOKEN).executeUpdate();
    }
}
