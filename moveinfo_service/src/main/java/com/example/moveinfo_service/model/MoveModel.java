package com.example.moveinfo_service.model;

import lombok.*;

@Data

@NoArgsConstructor
@Setter
@Getter
public class MoveModel {
    private String moveId;
//    private String name;
    private String title;
    private String Overview;
    private String original_language;



    public MoveModel(String moveId, String title, String overview, String original_language) {
        this.moveId =moveId;
        this.title = title;
        this.Overview = overview;
        this.original_language = original_language;
    }
}