package com.example.classifier_final_project.controllers.api;


import com.example.classifier_final_project.service.dto.PageToReadCountry;
import com.example.classifier_final_project.service.dto.countries.CountryToCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ICountryController extends IClassifierController<CountryToCreate, PageToReadCountry> {

    @Override
    @PostMapping("/country")
    ResponseEntity<CountryToCreate> create(@RequestBody CountryToCreate classifier);

    @Override
    @GetMapping("/country")
    ResponseEntity<PageToReadCountry> getPageOfClassifier(@RequestParam(name = "size", required = false,
                                                                defaultValue = "25") Integer size,
                                                  @RequestParam(name = "page", required = false,
                                                                defaultValue = "1") Integer page);

    @Override
    @GetMapping("/country/{uuid}")
    ResponseEntity<Boolean> searchByUUID(@PathVariable String uuid);
}
