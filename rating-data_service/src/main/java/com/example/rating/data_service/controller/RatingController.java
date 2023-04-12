package com.example.rating.data_service.controller;


import com.example.rating.data_service.model.RatingModel;
import com.example.rating.data_service.model.UserRatingModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("moves/api/")
public class RatingController {

    @GetMapping("/rating/{moveId}")
    public RatingModel getRating(@PathVariable("moveId") String moveId){
        return new RatingModel(moveId, 4);
    }
    @GetMapping("/user/{userId}")
    public List<UserRatingModel> getUserRating(@PathVariable("userId") String moveId){
        List<RatingModel> ratings = Arrays.asList(
                new RatingModel("1234",4),
                new RatingModel("5672",5),
                new RatingModel("4532",1),
                new RatingModel("1209",3),
                new RatingModel("5690",4)
        );
        UserRatingModel userRatingModel = new UserRatingModel();
        userRatingModel.setUserRatingModel(ratings);
       // return userRatingModel;
        return ratings;
    }
}
