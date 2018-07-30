package com.podskoczy.rx;


import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.swagger.annotations.OAuth2Definition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.LocalTime;

@SpringBootApplication
public class RxPlaygroundApplication implements ApplicationRunner {

    @Autowired
    private GitHubRepositoryDetails gitHubRepositoryDetails;

    public static void main(String[] args) {
        SpringApplication.run(RxPlaygroundApplication.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        LocalTime beforeParallel = LocalTime.now();
        Flowable.range(1, 10)
                .flatMap(v ->
                        Flowable.just(v)
                                .subscribeOn(Schedulers.io())
                                .map(v1 -> gitHubRepositoryDetails.getRepositoryDetails("allegro", "hermes"))
                                .doOnComplete(() -> System.out.println("Finished."))
                                .doOnError(e -> System.out.println("Error during."))
                ).blockingSubscribe();
        System.out.println(Duration.between(beforeParallel, LocalTime.now()).toMillis() + " ms.");

        LocalTime beforeSynchronized = LocalTime.now();
        for(int i=0; i<10; i++) {
            GitHubRepositoryDetailsModel repositoryDetailsModel = gitHubRepositoryDetails.getRepositoryDetails("allegro", "hermes");
            System.out.println("Finished.");
        }
        System.out.println(Duration.between(beforeSynchronized, LocalTime.now()).toMillis() + "ms.");
    }
}
