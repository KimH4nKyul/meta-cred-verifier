package proj.toy.blockchain.metacredverifier.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proj.toy.blockchain.metacredverifier.controller.usecase.VerifierUseCase;
import proj.toy.blockchain.metacredverifier.domain.VerifiedCredentialDomain;

@RestController
@RequestMapping(value = "/api/verifier")
@RequiredArgsConstructor
public class VerifierController {
    private final VerifierUseCase verifierUseCase;

    @PostMapping(value = "/verify-credential")
    public ResponseEntity<VerifiedCredentialResponse> verify() {
        return ResponseEntity.ok(VerifiedCredentialResponse.from(verifierUseCase.verify()));
    }
}


@Builder
@AllArgsConstructor
class VerifiedCredentialResponse {
     public static VerifiedCredentialResponse from(final VerifiedCredentialDomain verifiedCredentialDomain) {
        return new VerifiedCredentialResponse();
    }
}