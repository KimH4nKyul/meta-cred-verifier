package proj.toy.blockchain.metacredverifier.service.port;

import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;

public interface IVerifierRepository {
    public VerifierDomain save(final VerifierDomain verifierDomain);
}
