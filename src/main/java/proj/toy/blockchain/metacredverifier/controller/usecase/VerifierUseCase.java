package proj.toy.blockchain.metacredverifier.controller.usecase;

import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;

public interface VerifierUseCase {
    VerifierDomain verify(final String did, final String presentation);
}
