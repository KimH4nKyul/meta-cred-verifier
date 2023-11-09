package proj.toy.blockchain.metacredverifier.mock;

import lombok.Builder;
import proj.toy.blockchain.metacredverifier.controller.VerifierController;
import proj.toy.blockchain.metacredverifier.controller.usecase.VerifierUseCase;
import proj.toy.blockchain.metacredverifier.service.VerifierService;
import proj.toy.blockchain.metacredverifier.service.port.DidVerifierPort;
import proj.toy.blockchain.metacredverifier.service.port.HashHolder;
import proj.toy.blockchain.metacredverifier.service.port.VerifierRepositoryPort;

public class TestVerifierContainer {
    public final VerifierRepositoryPort verifierRepositoryPort;
    public final VerifierUseCase verifierUseCase;
    public final VerifierController verifierController;

    @Builder
    public TestVerifierContainer(final HashHolder hashHolder, final DidVerifierPort didVerifierPort) {
        // repository
        this.verifierRepositoryPort = new TestVerifierRepository();

        // service
        this.verifierUseCase = VerifierService.builder()
                .didVerifier(didVerifierPort)
                .hashHolder(hashHolder)
                .verifierRepository(this.verifierRepositoryPort)
                .build();

        // controller
        this.verifierController = new VerifierController(this.verifierUseCase);
    }
}
