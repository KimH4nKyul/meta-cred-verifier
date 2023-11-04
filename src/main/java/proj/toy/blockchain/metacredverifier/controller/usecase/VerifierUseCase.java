package proj.toy.blockchain.metacredverifier.controller.usecase;

import proj.toy.blockchain.metacredverifier.domain.VerifiedCredentialDomain;

public interface VerifierUseCase {
    VerifiedCredentialDomain verify();
}
