package proj.toy.blockchain.metacredverifier.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;

import java.util.UUID;

@Getter
@Builder
public class VerifiedPresentation {
    private UUID id;
    private String did;
    private String hash;
    private boolean verified;

    public static VerifiedPresentation from(VerifierDomain verifier) {
        return VerifiedPresentation.builder()
                .id(verifier.getId())
                .did(verifier.getDid())
                .hash(verifier.getHash())
                .verified(verifier.isVerified())
                .build();
    }
}
