package com.example.catalog_service.model;

import java.util.List;

public class UserRatingModel {
    private final String userId;
    private List<RatingModel> userRatingModel;

    public UserRatingModel(String userId) {
        this.userId = userId;
    }

    public List<RatingModel> getUserRatingModel(){
        return userRatingModel;
    }

    public void setUserRatingModel(List<RatingModel> userRatingModel) {
        this.userRatingModel = userRatingModel;
    }
}
