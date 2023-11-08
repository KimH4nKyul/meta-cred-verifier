package proj.toy.blockchain.metacredverifier.infrastructure.database.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "t_verifier")
public class VerifierJpaEntity {
    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    private String did;

    private String hash;

    private boolean verified;

    @PrePersist
    public void initUuid() {
        if( id == null ) id = UUID.randomUUID();
    }

    @Builder
    public VerifierJpaEntity(String did, String hash, boolean verified) {
        this.did = did;
        this.hash = hash;
        this.verified = verified;
    }

    public static VerifierJpaEntity from(VerifierDomain verifierDomain) {
        return VerifierJpaEntity.builder()
                .did(verifierDomain.getDid())
                .hash(verifierDomain.getHash())
                .verified(verifierDomain.isVerified())
                .build();
    }

    public VerifierDomain toDomain() {
        return VerifierDomain.builder()
                .id(this.id)
                .did(this.did)
                .hash(this.hash)
                .verified(this.verified)
                .build();
    }
}
