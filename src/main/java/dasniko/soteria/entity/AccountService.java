package dasniko.soteria.entity;

import dasniko.soteria.SecurityException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.Optional;

import static dasniko.soteria.SecurityException.Reason.INVALID_PASSWORD;
import static dasniko.soteria.SecurityException.Reason.INVALID_USERNAME;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Stateless
public class AccountService {

    @PersistenceContext
    private EntityManager em;

    public Optional<Account> getByUsername(final String username) {
        try {
            return Optional.of(
                em.createNamedQuery(Account.FIND_BY_USERNAME, Account.class)
                    .setParameter("username", username)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Optional<Account> getByEmail(final String email) {
        try {
            return Optional.of(
                em.createNamedQuery(Account.FIND_BY_EMAIL, Account.class)
                    .setParameter("email", email)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Optional<Account> getByLoginToken(String loginToken) {
        try {
            return Optional.of(
                em.createNamedQuery(Account.FIND_BY_TOKEN, Account.class)
                .setParameter("tokenHash", loginToken)
                .getSingleResult()
            );
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Account getByUsernameAndPassword(final String username, final String password) {
        Account account = getByUsername(username).orElseThrow(() -> new SecurityException(INVALID_USERNAME));

        if (!account.getPassword().equals(password)) {
            throw new SecurityException(INVALID_PASSWORD);
        }

        return account;
    }

    public Account save(final String username, final String password, final String email) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setEmail(email);
        account.setActive(true);
        account.setRoles(Collections.singleton("user"));
        return em.merge(account);
    }
}
