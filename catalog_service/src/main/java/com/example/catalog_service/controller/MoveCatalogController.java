package com.example.catalog_service.controller;

import com.example.catalog_service.model.CatalogModel;
import com.example.catalog_service.model.MoveModel;
import com.example.catalog_service.model.RatingModel;
import com.example.catalog_service.model.UserRatingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
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
@RequestMapping("/moves/api/catalog")
public class MoveCatalogController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClientBuilder;
   @GetMapping("/{userId}")
    public List<CatalogModel> getCatalog(@PathVariable("userId") String userId){

    //get all moveId from rated and  put the together
    UserRatingModel ratings = restTemplate.getForObject("http://Rating-Data-Service/moves/api/user/" + userId, UserRatingModel.class);
    return ratings.getUserRatingModel().stream().map(rating -> {
      MoveModel movie =   restTemplate.getForObject("http://Movie-Info-Service/moves/api/" + rating.getMoveId(), MoveModel.class);

       return new CatalogModel(movie.getName(), "the best movie  in the word ", rating.getRating());
    })
            .collect(Collectors.toList());

   }
}

//        MoveModel movie = webClientBuilder.build().get().uri("http://127.0.0.1:8080/moves/api/" + rating.getMoveId())
//                .retrieve()
//                .bodyToMono(MoveModel.class)
//                .block();

