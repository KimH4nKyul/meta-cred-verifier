package proj.toy.blockchain.metacredverifier.controller.usecase;

import proj.toy.blockchain.metacredverifier.domain.VerifierVerified;

public interface VerifierUseCase {
    VerifierVerified verify(final String did, final String presentation);
}
