package proj.toy.blockchain.metacredverifier.small.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import proj.toy.blockchain.metacredverifier.domain.VerifierDomain;
import proj.toy.blockchain.metacredverifier.mock.TestDidVerifier;
import proj.toy.blockchain.metacredverifier.mock.TestHashHolder;

import static org.junit.jupiter.api.Assertions.*;

public class VerifierDomainTest {

    private String did;
    private String presentation;
    private VerifierDomain verifier;

    @BeforeEach
    void init() {
        this.did = "did:meta:00000000000000000000000000000000000000000000000000000000000bd922";
        this.presentation = "eyJraWQiOiJkaWQ6bWV0YTowMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMGJkOTIxI01ldGFNYW5hZ2VtZW50S2V5IzI0MjI5ODc5ZGVjZDExNWZhZWM5NWFhODM4YzM2Y2I3YWJiODM1ZDkiLCJ0eXAiOiJKV1QiLCJhbGciOiJFUzI1NksifQ.eyJuYmYiOjE2ODA2NzQ5MjAsImlzcyI6ImRpZDptZXRhOjAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwYmQ5MjEiLCJ2cCI6eyJAY29udGV4dCI6WyJodHRwczpcL1wvdzNpZC5vcmdcL2NyZWRlbnRpYWxzXC92MSJdLCJ0eXBlIjpbIlZlcmlmaWFibGVQcmVzZW50YXRpb24iLCJPcHVzbVByZXNlbnRhdGlvbiJdLCJ2ZXJpZmlhYmxlQ3JlZGVudGlhbCI6WyJleUpyYVdRaU9pSmthV1E2YldWMFlUb3dNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TUdKa09USXhJMDFsZEdGTllXNWhaMlZ0Wlc1MFMyVjVJekkwTWpJNU9EYzVaR1ZqWkRFeE5XWmhaV001TldGaE9ETTRZek0yWTJJM1lXSmlPRE0xWkRraUxDSjBlWEFpT2lKS1YxUWlMQ0poYkdjaU9pSkZVekkxTmtzaWZRLmV5SnpkV0lpT2lKa2FXUTZiV1YwWVRvd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNR0prT1RJeElpd2libUptSWpveE5qZ3dOamMwT1RJd0xDSnBjM01pT2lKa2FXUTZiV1YwWVRvd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNREF3TURBd01EQXdNR0prT1RJeElpd2libTl1WTJVaU9pSlRURXg0WkcxQlpVVXhNMmxWY1Rad1RrZE1jREJRWkhNM2FUbFRVVzEwUjJaVmVpdEVLMVpSY0hKblBTSXNJblpqSWpwN0lrQmpiMjUwWlhoMElqcGJJbWgwZEhCek9sd3ZYQzkzTTJsa0xtOXlaMXd2WTNKbFpHVnVkR2xoYkhOY0wzWXhJbDBzSW5SNWNHVWlPbHNpVm1WeWFXWnBZV0pzWlVOeVpXUmxiblJwWVd3aUxDSk9ZVzFsUTNKbFpHVnVkR2xoYkNKZExDSmpjbVZrWlc1MGFXRnNVM1ZpYW1WamRDSTZleUp1WVcxbElqb2k2cm1BN1pXYzZyS3dJbjE5ZlEudkNSQ0x0SHVzUTJ4WmxmRzN3blN2MzJCN00zRkdLeUFIYThod09lMmNmN21QcHZvcGROSzF4QWp6YTFsWXFKQ21CUlFTMTlTSGZCdFhzMDZRbEFMaWciXX0sImlhdCI6MTY4MDY3NDkyMCwibm9uY2UiOiJqSW1wZnRGa0FmdGIxNDRsRjk4VkRET2lDbUJXdG1Nd1BrMkFrOUsrTG9FPSJ9.N-xZojUhQcGAbwwhN8iOZLvRmxlREFMZ_fKyqajs2wZtYm53YM_t_XV8FpfhS_csplLR8OQ237HFy2cXBI5_9g";
        this.verifier = VerifierDomain.adopt(this.did, this.presentation);
    }

    @DisplayName("verifier_can_adopt")
    @Test
    void canAdopt() throws Exception {
        // given
        // when
        // then
        assertAll(() ->
                {
                    Assertions.assertNull(verifier.getId());
                    Assertions.assertEquals(this.did, verifier.getDid());
                    Assertions.assertEquals(this.presentation, verifier.getPresentation());
                    Assertions.assertNull(verifier.getHash());
                    Assertions.assertFalse(verifier.isVerified());
                }
        );
    }

    @DisplayName("verifier_can_not_verify")
    @Test
    void canNotVerify() throws Exception {
        // given
        VerifierDomain failVerifier = VerifierDomain.adopt(this.did, "a failure value");
        this.verifier = failVerifier.verify(new TestDidVerifier());

        // when

        // then
        assertAll(() -> {
            assertFalse(this.verifier.isVerified());
        });
    }

    @DisplayName("verifier_can_verify")
    @Test
    void canVerify() throws Exception {
        // given
        // when
        verifier = verifier.verify(new TestDidVerifier());

        // then
        assertAll(() -> {
            Assertions.assertTrue(verifier.isVerified());
        });
    }

    @DisplayName("verifier_can_hash")
    @Test
    void canHash() throws Exception {
        // given

        // when
        verifier = verifier.hash(new TestHashHolder());

        // then
        assertAll(() -> {
            Assertions.assertEquals("hash", verifier.getHash());
        });
    }
}
