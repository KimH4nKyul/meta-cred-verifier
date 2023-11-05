package proj.toy.blockchain.metacredverifier.config;

import com.metaidum.did.resolver.client.DIDResolverAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class MetadiumConfiguration {

    private final MetadiumConfigurationProps metadiumConfigurationProps;

    @PostConstruct
    void initResolver() {
        DIDResolverAPI.getInstance().setResolverUrl(metadiumConfigurationProps.getResolver());
        System.out.println(metadiumConfigurationProps.getResolver());
    }
}
