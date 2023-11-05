package proj.toy.blockchain.metacredverifier.infrastructure.did;

import com.metadium.did.exception.DidException;
import com.metadium.did.verifiable.Verifier;
import com.metadium.vc.VerifiablePresentation;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Component;
import proj.toy.blockchain.metacredverifier.service.port.DidVerifierPort;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@Component
class MetadiumDidVerifier implements DidVerifierPort {

    private final Verifier verifier = new Verifier();

    @Override
    public boolean verify(String presentation) {
        VerifiablePresentation vp = toVerifiablePresentation(presentation);
        for (Object credential : vp.getVerifiableCredentials()) validateCredential(toSignedJwt((String) credential));
        return true;
    }

    private void validateCredential(SignedJWT vc) {
        if (isExpired(vc)) throw new RuntimeException("유효기간 초과");
        if (!isVerified(vc)) throw new RuntimeException("검증 실패");
    }

    private boolean isVerified(SignedJWT vc) {
        try {
            return verifier.verify(vc);
        } catch (IOException | DidException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isExpired(SignedJWT vc) {
        try {
            Date expirationTime = vc.getJWTClaimsSet().getExpirationTime();
            return expirationTime != null && expirationTime.before(new Date());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private VerifiablePresentation toVerifiablePresentation(String presentation) {
        try {
            return new VerifiablePresentation(toSignedJwt(presentation));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private SignedJWT toSignedJwt(String presentation) {
        try {
            return SignedJWT.parse(presentation);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
