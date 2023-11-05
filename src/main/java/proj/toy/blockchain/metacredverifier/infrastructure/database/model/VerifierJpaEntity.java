package proj.toy.blockchain.metacredverifier.infrastructure.database.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class VerifierJpaEntity {
    @Id
    @GeneratedValue
    private Long id;

    public static VerifierJpaEntity from(final VerifierDomain verifierDomain) {
        return new VerifierJpaEntity();
    }
}
