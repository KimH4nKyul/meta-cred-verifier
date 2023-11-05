package proj.toy.blockchain.metacredverifier.infrastructure.database;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import proj.toy.blockchain.metacredverifier.infrastructure.database.model.VerifierJpaRepository;
import proj.toy.blockchain.metacredverifier.service.port.VerifierRepositoryPort;

@Repository
@RequiredArgsConstructor
public class VerifierRepository implements VerifierRepositoryPort {

    private final VerifierJpaRepository verifierJpaRepository;

    @Override
    public void save() {

    }
}
