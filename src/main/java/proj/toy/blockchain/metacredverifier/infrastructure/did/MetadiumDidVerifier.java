package proj.toy.blockchain.metacredverifier.infrastructure.did;

import com.metadium.did.exception.DidException;
import com.metadium.did.verifiable.Verifier;
import com.metadium.vc.VerifiablePresentation;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import proj.toy.blockchain.metacredverifier.domain.exception.NoSuchExpirationException;
import proj.toy.blockchain.metacredverifier.domain.exception.VerificationException;
import proj.toy.blockchain.metacredverifier.service.port.DidVerifierPort;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;

@Component
class MetadiumDidVerifier implements DidVerifierPort {
    @Override
    public boolean verify(String presentation) {
        return validatePresentation(presentation) && validateCredentials(presentation);
    }

    private boolean validateCredentials(String presentation) {
        return credentials(presentation).stream()
                .map(String.class::cast)
                .allMatch(credential -> validate(toSignedJwt(credential)));
    }

    private Collection<Object> credentials(String presentation) {
        return toVerifiablePresentation(presentation).getVerifiableCredentials();
    }

    private boolean validatePresentation(String presentation) {
        return validate(toSignedJwt(presentation));
    }

    private boolean validate(SignedJWT jwt) {
        return validateExpiration(jwt) && validateToken(jwt);
    }

    private boolean validateExpiration(SignedJWT jwt) {
        return !isExpired(jwt);
    }

    private boolean validateToken(SignedJWT jwt) {
        return isVerified(jwt);
    }

    private boolean isVerified(SignedJWT jwt) {
        try {
            final Verifier verifier = new Verifier();
            return verifier.verify(jwt);
        } catch (IOException | DidException e) {
            throw new VerificationException();
        }
    }

    private boolean isExpired(SignedJWT jwt) {
        try {
            return expiration(jwt.getJWTClaimsSet().getExpirationTime());
        } catch (ParseException e) {
            throw new NoSuchExpirationException();
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
