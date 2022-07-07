package com.example.classifier_final_project.controllers.api;

import com.example.classifier_final_project.service.dto.PageToReadConcert;
import com.example.classifier_final_project.service.dto.concerts.ConcertToCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IConcertController extends IClassifierController<ConcertToCreate,PageToReadConcert>{

    @Override
    @PostMapping("/concert/category")
    ResponseEntity<ConcertToCreate> create(@RequestBody ConcertToCreate classifier);

    @Override
    @GetMapping("/concert/category")
    ResponseEntity<PageToReadConcert> getPageOfClassifier(@RequestParam(name = "size",
                                                                required = false,
                                                                defaultValue = "25") Integer size,
                                                          @RequestParam(name = "page",required = false,
                                                                defaultValue = "1") Integer page);

    @Override
    @GetMapping("/concert/category/{uuid}")
    ResponseEntity<Boolean> searchByUUID(@PathVariable String uuid);
}
