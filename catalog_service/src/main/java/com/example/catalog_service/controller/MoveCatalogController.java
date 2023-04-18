package com.example.catalog_service.controller;

import com.example.catalog_service.model.CatalogModel;
import com.example.catalog_service.model.MoveModel;
import com.example.catalog_service.model.UserRatingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/moves/api/catalog")
public class MoveCatalogController {

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/{userId}")
    private UserRatingModel userRatingModel(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://Rating-Data-Service/moves/api/user/" + userId, UserRatingModel.class);
        //Logger.getLogger("MoveCatalogController").info(userId);
    }
    public List<CatalogModel> getCatalog(@PathVariable("userId") String userId) {
        UserRatingModel ratings = new UserRatingModel(userId);

        return ratings.getUserRatingModel().stream().map(rating -> {
                    MoveModel movie = restTemplate.getForObject("http://Movie-Info-Service/moves/api/" + rating.getMoveId(), MoveModel.class);
                    return new CatalogModel(movie.getName(), "the best movie  in the word ", rating.getRating());
                })
                .collect(Collectors.toList());
    }




}

//        MoveModel movie = webClientBuilder.build().get().uri("http://127.0.0.1:8080/moves/api/" + rating.getMoveId())
//                .retrieve()
//                .bodyToMono(MoveModel.class)
//                .block();

