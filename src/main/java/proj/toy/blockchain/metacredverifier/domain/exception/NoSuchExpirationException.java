package proj.toy.blockchain.metacredverifier.domain.exception;

public class NoSuchExpirationException extends RuntimeException {
    public NoSuchExpirationException() {
        super("유효기간을 확인할 수 없음");
    }
}
