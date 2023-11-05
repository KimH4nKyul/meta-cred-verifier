package proj.toy.blockchain.metacredverifier.service.port;

public interface DidVerifierPort {
    boolean verify(final String presentation);
}
