package proj.toy.blockchain.metacredverifier.controller.response;

import com.fasterxml.uuid.Generators;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import proj.toy.blockchain.metacredverifier.controller.dto.response.VerifiedPresentation;
import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class VerifiedPresentationTest {
    @DisplayName("VerifierDomain으로 응답을 생성할 수 있음")
    @Test
    void can_create_response_from_verifier_domain() throws Exception {
        // given
        UUID id = Generators.timeBasedGenerator().generate();

        // when
        VerifiedPresentation resposne = VerifiedPresentation.from(
                VerifierDomain.builder()
                        .id(id)
                        .did("did:meta:1234")
                        .hash("hash")
                        .verified(true)
                        .build()
        );

        // then
        VerifiedPresentation finalResposne = resposne;
        assertAll(() -> {
            assertEquals(id, finalResposne.getId());
            assertEquals("did:meta:1234", finalResposne.getDid());
            assertEquals("hash", finalResposne.getHash());
            assertTrue(resposne.isVerified());
        });
    }
}
