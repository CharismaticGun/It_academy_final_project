package com.example.classifier_final_project.controllers;


import com.example.classifier_final_project.controllers.api.ICountryController;
import com.example.classifier_final_project.service.dto.PageToReadCountry;
import com.example.classifier_final_project.service.dto.countries.CountryToCreate;
import com.example.classifier_final_project.service.api.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController implements ICountryController {

    private final ICountryService countryService;

    @Autowired
    public CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public ResponseEntity<CountryToCreate> create(CountryToCreate classifier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.create(classifier));
    }

    @Override
    public ResponseEntity<PageToReadCountry> getPageOfClassifier(Integer size, Integer page) {
        return ResponseEntity.ok(countryService.getPageOfClassifier(size,page));
    }

    @Override
    public ResponseEntity<Boolean> searchByUUID(String uuid) {
        return ResponseEntity.ok(countryService.searchByUuid(uuid));
    }
}
