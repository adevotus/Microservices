package com.example.catalog_service.controller;

import com.example.catalog_service.model.CatalogModel;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/moves/api/catalog")
public class MoveCatalogController {
@GetMapping("/{userId}")
    public List<CatalogModel> getCatalog(@PathVariable("userId") String userId){
return Collections.singletonList(
       new CatalogModel("Transport " , "the best movie  in the word ", 3)
        );
    }
}
