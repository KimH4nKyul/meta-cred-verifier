package proj.toy.blockchain.metacredverifier.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import proj.toy.blockchain.metacredverifier.domain.VerifierVerified;

@Getter
@Builder
public
class VerifiedCredentialResponse {
    public static VerifiedCredentialResponse from(final VerifierVerified verifierVerified) {
        return VerifiedCredentialResponse.builder().build();
    }
}
