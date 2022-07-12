package com.example.classifier_final_project.service.api;


import com.example.classifier_final_project.service.dto.PageToReadClassifier;
import com.example.classifier_final_project.service.dto.concerts.ConcertToCreate;
import com.example.classifier_final_project.service.dto.concerts.ConcertToRead;


public interface IConcertService extends IClassifierService<ConcertToCreate, PageToReadClassifier<ConcertToRead>> {}
