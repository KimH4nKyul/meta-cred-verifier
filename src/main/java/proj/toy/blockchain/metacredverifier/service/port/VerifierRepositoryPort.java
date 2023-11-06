package proj.toy.blockchain.metacredverifier.service.port;

import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;

import java.util.Optional;
import java.util.UUID;

public interface VerifierRepositoryPort {
    VerifierDomain save(VerifierDomain verifier);
    Optional<VerifierDomain> findById(UUID id);
}
