package proj.toy.blockchain.metacredverifier.service.port;

import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;

public interface VerifierRepositoryPort {
    public VerifierDomain save(VerifierDomain verifier);
}
