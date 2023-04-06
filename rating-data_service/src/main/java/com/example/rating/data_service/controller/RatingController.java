package com.example.rating.data_service.controller;


import com.example.rating.data_service.model.RatingModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("moves/api/")
public class RatingController {

    @GetMapping("/rating/{moveId}")
    public RatingModel getRating(@PathVariable("moveId") String moveId){
        return new RatingModel(moveId, 4);
    }
}
