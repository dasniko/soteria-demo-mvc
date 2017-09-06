package dasniko.soteria.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.MONTHS;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@Data
@Entity
@EqualsAndHashCode(of = "id")
@NamedQueries({
    @NamedQuery(name = Token.REMOVE_TOKEN, query = "delete from Token t where t.tokenHash = :tokenHash"),
})
public class Token {

    public static final String REMOVE_TOKEN = "removeToken";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tokenHash;
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;
    private Instant created;
    private Instant expiration;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @PrePersist
    public void prePersist() {
        created = Instant.now();
        if (expiration == null) {
            expiration = created.plus(1, MONTHS);
        }
    }
}
