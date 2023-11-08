package proj.toy.blockchain.metacredverifier.mock;

import proj.toy.blockchain.metacredverifier.service.port.DidVerifierPort;

public class TestDidVerifier implements DidVerifierPort {

    @Override
    public boolean verify(String presentation) {
        if(presentation != null && presentation.contains("eyJ"))
            return true;
        return false;
    }
}
