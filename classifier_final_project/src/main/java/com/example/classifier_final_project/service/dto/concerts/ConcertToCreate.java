package com.example.classifier_final_project.service.dto.concerts;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ConcertToCreate {


    private String title;

    public ConcertToCreate(){}

    public ConcertToCreate(String title) {
        this.title = title;
    }

    @NotNull(message = "Concert category title should be filled")
    @Length(min = 3,max = 10,message = "Concert title length must be between 3 and 10  character")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
