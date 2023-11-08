package proj.toy.blockchain.metacredverifier.mock;

import proj.toy.blockchain.metacredverifier.service.port.HashHolder;

public class TestHashHolder implements HashHolder {

    @Override
    public String hash(String input) {
        return "hash";
    }
}
