package proj.toy.blockchain.metacredverifier.mock;

import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;
import proj.toy.blockchain.metacredverifier.service.port.VerifierRepositoryPort;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class TestVerifierRepository implements VerifierRepositoryPort {

    private final Map<UUID, VerifierDomain> data = new HashMap<>();

    @Override
    public VerifierDomain save(VerifierDomain verifier) {
        final UUID key = UUID.randomUUID();
        VerifierDomain newVerifier = VerifierDomain.builder()
                .id(key)
                .did(verifier.getDid())
                .presentation(verifier.getPresentation())
                .hash(verifier.getHash())
                .verified(verifier.isVerified())
                .build();
        data.put(key, newVerifier);
        return data.get(key);
    }

    @Override
    public Optional<VerifierDomain> findById(UUID id) {
        return Optional.ofNullable(data.get(id));
    }
}
