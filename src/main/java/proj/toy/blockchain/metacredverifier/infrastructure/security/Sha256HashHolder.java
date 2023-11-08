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
            return base64Encode(input);
    }

    private String base64Encode(final String input) {
        final byte[] hash = digest(input);
        final byte[] halfHash = arrayCopyOf(hash);
        return Base64.getEncoder().encodeToString(halfHash);
    }

    private byte[] digest(final String input) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    private byte[] arrayCopyOf(final byte[] hash) {
        final byte[] halfHash = new byte[16];
        System.arraycopy(hash, 0, halfHash, 0, 16);
        return halfHash;
    }
}
