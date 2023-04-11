package com.example.catalog_service.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RatingModel {


    private String moveId;
    private int rating;
}
