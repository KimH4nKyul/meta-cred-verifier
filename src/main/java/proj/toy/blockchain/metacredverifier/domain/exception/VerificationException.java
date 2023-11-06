package proj.toy.blockchain.metacredverifier.domain.exception;

public class VerificationException extends RuntimeException {
    public VerificationException() {
        super("검증 실패");
    }
}
