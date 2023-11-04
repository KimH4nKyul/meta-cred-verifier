package proj.toy.blockchain.metacredverifier.service;

import org.springframework.stereotype.Service;
import proj.toy.blockchain.metacredverifier.controller.usecase.VerifierUseCase;
import proj.toy.blockchain.metacredverifier.domain.VerifiedCredentialDomain;

@Service
public class VerifierService implements VerifierUseCase {

    @Override
    public VerifiedCredentialDomain verify() {
        return null;
    }
}
