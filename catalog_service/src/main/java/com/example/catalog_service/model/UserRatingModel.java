package com.example.catalog_service.model;

import java.util.List;

public class UserRatingModel {
    private List<RatingModel> userRatingModel;
    public List<RatingModel> getUserRatingModel(){
        return userRatingModel;
    }

    public void setUserRatingModel(List<RatingModel> userRatingModel) {
        this.userRatingModel = userRatingModel;
    }
}
