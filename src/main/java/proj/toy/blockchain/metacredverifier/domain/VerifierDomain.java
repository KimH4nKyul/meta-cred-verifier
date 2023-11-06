package proj.toy.blockchain.metacredverifier.domain;

import lombok.Builder;
import lombok.Getter;
import proj.toy.blockchain.metacredverifier.service.port.DidVerifierPort;
import proj.toy.blockchain.metacredverifier.service.port.HashHolder;

import java.util.UUID;

@Getter
public
class VerifierDomain {
    private final UUID id;
    private final String did;
    private final String presentation;
    private final String hash;
    private final boolean verified;

    @Builder
    public VerifierDomain(UUID id, String did, String presentation, String hash, boolean verified) {
        this.id = id;
        this.did = did;
        this.presentation = presentation;
        this.hash = hash;
        this.verified = verified;
    }

    public static VerifierDomain adopt(String did, String presentation) {
        return VerifierDomain.builder()
                .did(did)
                .presentation(presentation)
                .build();
    }

    public VerifierDomain verify(DidVerifierPort didVerifier) {
        return VerifierDomain.builder()
                .did(this.did)
                .presentation(this.presentation)
                .verified(didVerifier.verify(this.presentation))
                .build();
    }

    public VerifierDomain hash(HashHolder hashHolder) {
        return VerifierDomain.builder()
                .did(this.did)
                .presentation(this.presentation)
                .hash(hashHolder.hash(this.presentation))
                .verified(this.verified)
                .build();
    }
}
