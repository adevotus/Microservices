package com.example.moveinfo_service.controller;

import com.example.moveinfo_service.model.MoveModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/moves/api")
public class MoveController {


    @Value("${api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public MoveController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{moveId}")
    public MoveModel getMoveInfo(@PathVariable ("moveId" ) String moveId){
        MoveModel moveModel = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + moveId + "?api_key=" + apiKey, MoveModel.class);
    return new MoveModel(moveId, moveModel.getTitle(), moveModel.getOverview(),moveModel.getOriginal_language());

    }
}
