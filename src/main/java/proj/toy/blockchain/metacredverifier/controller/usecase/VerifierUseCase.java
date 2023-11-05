package proj.toy.blockchain.metacredverifier.controller.usecase;

public interface VerifierUseCase {
    void verify(final String did, final String presentation);
}
