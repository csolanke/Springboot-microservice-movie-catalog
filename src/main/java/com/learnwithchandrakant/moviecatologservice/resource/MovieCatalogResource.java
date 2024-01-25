package com.learnwithchandrakant.moviecatologservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

 @Autowired
public RestTemplate restTemplate;

 @Autowired
 private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating=restTemplate.getForObject("http://rating-data-service/ratingdata/users/"+userId,UserRating.class);

        return userRating.getUserRating().stream().map(rating-> {
            Movie movie=restTemplate.getForObject("http://movie-info-service/movie/"+ rating.getMovidId(),Movie.class);
            return  new CatalogItem(movie.getName(), "Desc",rating.getRating());
        }).collect(Collectors.toList());


    }
}

 /* Movie movie =webClientBuilder.build().get().uri("http://localhost:9090/movie/"+ rating.getMovidId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

             */

//Mono is a reactive way of saying i.e getting result/objet back from asynchronous call.
