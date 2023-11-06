package proj.toy.blockchain.metacredverifier.domain.exception;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(UUID id) {
        super(id + "를 찾을 수 없음");
    }
}
