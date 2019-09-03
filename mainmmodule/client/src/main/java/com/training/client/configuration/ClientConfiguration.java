package com.training.client.configuration;

import io.sphere.sdk.client.BlockingSphereClient;
import io.sphere.sdk.client.SphereClient;
import io.sphere.sdk.client.SphereClientConfig;
import io.sphere.sdk.client.SphereClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.TimeUnit;

@Configuration
@ConfigurationProperties("app")
@PropertySource("classpath:dev.yml")
public class ClientConfiguration {

    @Value("${projectKey}")
    private String projectKey;

    @Value("${clientId}")
    private String clientId;

    @Value("${clientSecret}")
    private String clientSecret;

    @Value("${apiUrl}")
    private String apiUrl;

    @Value("${authUrl}")
    private String authUrl;

    @Value("${timeout}")
    private int timeout;


    @Bean
    public BlockingSphereClient createSphereClient() {
        final SphereClientConfig sphereClientConfig = SphereClientConfig.of(projectKey, clientId, clientSecret, authUrl, apiUrl);
        final SphereClient client = SphereClientFactory.of().createClient(sphereClientConfig);
        return BlockingSphereClient.of(client, timeout, TimeUnit.SECONDS);
    }
}
