package proj.toy.blockchain.metacredverifier.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import proj.toy.blockchain.metacredverifier.domain.DidDocumentType;

@Getter
public class ExpirationException extends RuntimeException {
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public ExpirationException() {
        super("유효기간 초과");
    }
    public ExpirationException(DidDocumentType didDocumentType) {
        super(didDocumentType.name() + "의 유효기간 초과");
    }
}
