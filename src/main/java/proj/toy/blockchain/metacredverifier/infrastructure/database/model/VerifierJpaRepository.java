package proj.toy.blockchain.metacredverifier.infrastructure.database.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VerifierJpaRepository extends JpaRepository<VerifierJpaEntity, UUID> {
    Optional<VerifierJpaEntity> findById(UUID id);
}
