package proj.toy.blockchain.metacredverifier.infrastructure.security;

import org.springframework.stereotype.Component;
import proj.toy.blockchain.metacredverifier.service.port.HashHolder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class Sha256HashHolder implements HashHolder {
    @Override
    public String hash(String input) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            final byte[] halfHash = new byte[16];
            System.arraycopy(hash, 0, halfHash, 0, 16);
            return Base64.getEncoder().encodeToString(halfHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
