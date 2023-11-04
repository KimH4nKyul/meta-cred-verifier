package proj.toy.blockchain.metacredverifier.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "vdr.metadium")
public class MetadiumConfigurationProps {
    private String resolverUrl;

    public String getResolver() {
        return this.resolverUrl;
    }

    public void setResolverUrl(final String resolverUrl) {
        this.resolverUrl = resolverUrl;
    }
}
