package com.example.classifier_final_project.service.api;

import com.example.classifier_final_project.service.dto.PageToReadClassifier;
import com.example.classifier_final_project.service.dto.countries.CountryToCreate;
import com.example.classifier_final_project.service.dto.countries.CountryToRead;

public interface ICountryService extends IClassifierService<CountryToCreate, PageToReadClassifier<CountryToRead>>{}
