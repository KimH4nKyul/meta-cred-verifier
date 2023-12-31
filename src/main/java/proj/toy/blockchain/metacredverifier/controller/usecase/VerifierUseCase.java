package proj.toy.blockchain.metacredverifier.controller.usecase;

import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;

import java.util.UUID;

public interface VerifierUseCase {
    VerifierDomain verify(final String did, final String presentation);
    VerifierDomain findById(final UUID id);
}
