package proj.toy.blockchain.metacredverifier.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import proj.toy.blockchain.metacredverifier.controller.dto.request.DidAndPresentation;
import proj.toy.blockchain.metacredverifier.controller.dto.response.VerifiedPresentation;
import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;
import proj.toy.blockchain.metacredverifier.mock.TestDidVerifier;
import proj.toy.blockchain.metacredverifier.mock.TestHashHolder;
import proj.toy.blockchain.metacredverifier.mock.TestVerifierContainer;

import static org.junit.jupiter.api.Assertions.*;

public class VerifierControllerTest {
    private VerifierController verifierController;
    private TestVerifierContainer testVerifierContainer;

    @BeforeEach
    void init() {
        this.testVerifierContainer = TestVerifierContainer.builder()
                .hashHolder(new TestHashHolder())
                .didVerifierPort(new TestDidVerifier())
                .build();
        this.verifierController = this.testVerifierContainer.verifierController;
    }
    
    @DisplayName("can_verify")
    @Test
    void canVerfiy() throws Exception {
        // given
        DidAndPresentation didAndPresentation = new DidAndPresentation();
        didAndPresentation.setDid("did:meta:1234");
        didAndPresentation.setPresentation("eyJ1234");


        // when
        ResponseEntity<VerifiedPresentation> response = verifierController.verify(didAndPresentation);


        // then
        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody().getId());
            assertEquals("did:meta:1234", response.getBody().getDid());
            assertEquals("hash", response.getBody().getHash());
            assertTrue(response.getBody().isVerified());
        });
    }

    @DisplayName("can_find_by_id")
    @Test
    void can_find_by_id() throws Exception {
        // given
        VerifierDomain verifier = this.testVerifierContainer.verifierRepositoryPort.save(
                VerifierDomain.builder()
                        .did("did:meta:1234")
                        .presentation("eyJ1234")
                        .hash("hash")
                        .verified(true)
                        .build()
        );

        // when
        ResponseEntity<VerifiedPresentation> response = this.verifierController.findById(verifier.getId().toString());

        // then
        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(verifier.getId(), response.getBody().getId());
            assertEquals("did:meta:1234", response.getBody().getDid());
            assertEquals("hash", response.getBody().getHash());
            assertTrue(response.getBody().isVerified());
        });
    }
}
