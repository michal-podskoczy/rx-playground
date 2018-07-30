package com.podskoczy.rx;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
public class GitHubRepositoryDetailsModel {

    private String full_name;
    private String clone_url;
    private String description;
    private LocalDateTime created_at;
    private Integer stargazers_count;

}
