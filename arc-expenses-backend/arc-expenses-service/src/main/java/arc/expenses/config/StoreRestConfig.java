package arc.expenses.config;

import eu.openminted.store.restclient.StoreRESTClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StoreRestConfig {

    @Value("${services.store.ip}")
    private String storeHost;

    @Bean
    StoreRESTClient storeRESTClient() {
        return new StoreRESTClient(storeHost);
    }

    public String getStoreHost() {
        return storeHost;
    }

    public void setStoreHost(String storeHost) {
        this.storeHost = storeHost;
    }
}
