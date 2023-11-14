package proj.toy.blockchain.metacredverifier.domain.exception;

public class InvalidPresentationException extends RuntimeException {
    public InvalidPresentationException() {
        super("VP가 유효하지 않음");
    }
}
