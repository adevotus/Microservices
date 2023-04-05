package com.example.catalog_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CatalogModel {
     private String name;
     private String descr;
     private int rating;
}
