package proj.toy.blockchain.metacredverifier.domain;

public enum DidDocumentType {
    PRESENTATION("PRESENTATION"),
    CREDENTIAL("CREDENTIAL");

    private String name;

    DidDocumentType(final String name) {
        this.name = name;
    }
}
