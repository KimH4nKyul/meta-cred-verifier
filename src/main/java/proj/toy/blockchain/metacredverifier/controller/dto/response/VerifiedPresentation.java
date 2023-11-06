package proj.toy.blockchain.metacredverifier.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;

@Getter
@Builder
public class VerifiedPresentation {
    private String uuid;
    private String did;
    private String hash;
    private boolean verified;

    public static VerifiedPresentation from(VerifierDomain verifier) {
        return VerifiedPresentation.builder()
                .uuid(verifier.getUuid())
                .did(verifier.getDid())
                .hash(verifier.getHash())
                .verified(verifier.isVerified())
                .build();
    }
}
