package proj.toy.blockchain.metacredverifier.infrastructure.did;

import proj.toy.blockchain.metacredverifier.service.port.DidVerifierPort;

class MetadiumDidVerifier implements DidVerifierPort {
    @Override
    public boolean verify(String presentation) {
        return false;
    }
}
