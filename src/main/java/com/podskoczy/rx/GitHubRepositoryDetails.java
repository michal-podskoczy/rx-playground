package com.podskoczy.rx;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
public class GitHubRepositoryDetails {

    private static final String GET_REPOSITORY_URL = "https://api.github.com/repos/{owner}/{repository}";

    private String token;

    private RestTemplate restTemplate;

    public GitHubRepositoryDetailsModel getRepositoryDetails(String owner, String repository) {

        String url = GET_REPOSITORY_URL.replace("{owner}", owner)
                .replace("{repository}", repository);

        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "token: {token}".replace("{token}", token));
        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity<GitHubRepositoryDetailsModel> gitHubRepositoryDetailsModel = restTemplate.exchange(url, HttpMethod.GET, httpEntity, GitHubRepositoryDetailsModel.class);
        return gitHubRepositoryDetailsModel.getBody();
    }

}
