package proj.toy.blockchain.metacredverifier.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proj.toy.blockchain.metacredverifier.controller.usecase.VerifierUseCase;
import proj.toy.blockchain.metacredverifier.service.port.DidVerifierPort;
import proj.toy.blockchain.metacredverifier.service.port.IVerifierRepository;

@Service
@RequiredArgsConstructor
public class VerifierService implements VerifierUseCase {

    private final IVerifierRepository verifierRepository;
    private final DidVerifierPort didVerifier;

    @Override
    public void verify(final String did, final String presentation) {
        didVerifier.verify(presentation);
    }
}
