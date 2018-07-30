package com.podskoczy.rx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource(value = "classpath:secure.properties", ignoreResourceNotFound = true)
public class RxPlaygroundConfiguration {

    @Bean
    public GitHubRepositoryDetails gitHubRepositoryDetails(@Value("${github.oath.token:}") String authorizationToken) {
        RestTemplate restTemplate = new RestTemplate();
        return new GitHubRepositoryDetails(authorizationToken, restTemplate);
    }

}
