package proj.toy.blockchain.metacredverifier.infrastructure.database.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifierJpaRepository extends JpaRepository<VerifierJpaEntity, Long> {
}
