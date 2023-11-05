package proj.toy.blockchain.metacredverifier.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import proj.toy.blockchain.metacredverifier.domain.DidDocumentType;


@Getter
public class VerificationException extends RuntimeException {
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public VerificationException() {
        super("검증 실패");
    }
    public VerificationException(DidDocumentType didDocumentType) {
        super(didDocumentType.name() + "의 검증 실패");
    }
}
