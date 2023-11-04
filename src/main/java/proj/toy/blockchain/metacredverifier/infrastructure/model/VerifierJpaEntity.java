package proj.toy.blockchain.metacredverifier.infrastructure.model;

import lombok.Builder;
import lombok.Getter;
import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;

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
