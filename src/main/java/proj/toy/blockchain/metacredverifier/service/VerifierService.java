package proj.toy.blockchain.metacredverifier.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.toy.blockchain.metacredverifier.controller.usecase.VerifierUseCase;
import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;
import proj.toy.blockchain.metacredverifier.domain.exception.ResourceNotFoundException;
import proj.toy.blockchain.metacredverifier.service.port.DidVerifierPort;
import proj.toy.blockchain.metacredverifier.service.port.HashHolder;
import proj.toy.blockchain.metacredverifier.service.port.VerifierRepositoryPort;

import java.util.UUID;

@Service
@Builder
@RequiredArgsConstructor
public class VerifierService implements VerifierUseCase {

    private final VerifierRepositoryPort verifierRepository;
    private final DidVerifierPort didVerifier;
    private final HashHolder hashHolder;

    @Override
    @Transactional
    public VerifierDomain verify(final String did, final String presentation) {
        VerifierDomain verifier = VerifierDomain.adopt(did, presentation);
        verifier = verifier.verify(didVerifier);
        verifier = verifier.hash(hashHolder);
        verifier = verifierRepository.save(verifier);
        return verifier;
    }

    @Override
    public VerifierDomain findById(UUID id) {
        return verifierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}


