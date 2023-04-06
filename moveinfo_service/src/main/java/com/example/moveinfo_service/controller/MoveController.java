package com.example.moveinfo_service.controller;

import com.example.moveinfo_service.model.MoveModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moves/api")
public class MoveController {

    @GetMapping("/{moveId}")
    public MoveModel getMoveInfo(@PathVariable ("moveId" ) String moveId){
return new MoveModel(moveId, "The best in the word");
    }
}
