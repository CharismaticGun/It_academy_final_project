package com.example.classifier_final_project.service.dto.concerts;

public class ConcertToCreate {

    private String title;

    public ConcertToCreate(){}

    public ConcertToCreate(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
