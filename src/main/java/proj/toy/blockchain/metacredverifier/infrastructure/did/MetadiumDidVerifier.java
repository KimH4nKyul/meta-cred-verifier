package proj.toy.blockchain.metacredverifier.infrastructure.did;

import com.metadium.did.exception.DidException;
import com.metadium.did.verifiable.Verifier;
import com.metadium.vc.VerifiablePresentation;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Component;
import proj.toy.blockchain.metacredverifier.domain.DidDocumentType;
import proj.toy.blockchain.metacredverifier.domain.exception.ExpirationException;
import proj.toy.blockchain.metacredverifier.domain.exception.VerificationException;
import proj.toy.blockchain.metacredverifier.service.port.DidVerifierPort;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@Component
class MetadiumDidVerifier implements DidVerifierPort {

    @Override
    public boolean verify(String presentation) {
        validatePresentation(presentation);
        validateCredentials(toVerifiablePresentation(presentation));
        return true;
    }

    private void validateCredentials(VerifiablePresentation vp) {
        for (Object credential : vp.getVerifiableCredentials())
            validate(toSignedJwt((String) credential), DidDocumentType.CREDENTIAL);
    }

    private void validatePresentation(String presentation) {
        validate(toSignedJwt(presentation), DidDocumentType.PRESENTATION);
    }

    private void validate(SignedJWT jwt, DidDocumentType didDocumentType) {
        validateExpiration(jwt, didDocumentType);
        validateToken(jwt, didDocumentType);
    }

    private void validateExpiration(SignedJWT jwt, DidDocumentType didDocumentType) {
        if (isExpired(jwt)) throw new ExpirationException(didDocumentType);
    }

    private void validateToken(SignedJWT jwt, DidDocumentType didDocumentType) {
        if (!isVerified(jwt)) throw new VerificationException(didDocumentType);
    }

    private boolean isVerified(SignedJWT jwt) {
        try {
            final Verifier verifier = new Verifier();
            return verifier.verify(jwt);
        } catch (IOException | DidException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isExpired(SignedJWT jwt) {
        try {
            return expiration(jwt.getJWTClaimsSet().getExpirationTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean expiration(Date expirationTime) {
        return expirationTime != null && expirationTime.before(new Date());
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
