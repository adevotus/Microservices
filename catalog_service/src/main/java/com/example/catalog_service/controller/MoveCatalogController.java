package com.example.catalog_service.controller;

import com.example.catalog_service.model.CatalogModel;
import com.example.catalog_service.model.MoveModel;
import com.example.catalog_service.model.RatingModel;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/moves/api/catalog")
public class MoveCatalogController {
@GetMapping("/{userId}")
    public List<CatalogModel> getCatalog(@PathVariable("userId") String userId){

    RestTemplate restTemplate = new RestTemplate();
    MoveModel movie = restTemplate.getForObject("http://127.0.0.1:8080/moves/api/foor", MoveModel.class);
    //get all moveId from rated and  put the together

    List<RatingModel>ratings = Arrays.asList(
            new RatingModel("1234",4),
            new RatingModel("5672",5),
            new RatingModel("4532",1),
            new RatingModel("1209",3),
            new RatingModel("5690",4)
    );
    return (List<CatalogModel>) ratings.stream().map(rating -> {
        restTemplate.getForObject("http://127.0.0.1:8080/moves/api/" + rating.getMoveId(), MoveModel.class);
       return new CatalogModel("Transport " , "the best movie  in the word ", rating.getRating());
    });
//            .collect(Collectors.toList());

   }
}

