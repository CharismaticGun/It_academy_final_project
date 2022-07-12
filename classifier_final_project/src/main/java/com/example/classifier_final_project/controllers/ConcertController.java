package com.example.classifier_final_project.controllers;

import com.example.classifier_final_project.controllers.api.IConcertController;
import com.example.classifier_final_project.service.api.IConcertService;
import com.example.classifier_final_project.service.dto.PageToReadClassifier;
import com.example.classifier_final_project.service.dto.concerts.ConcertToCreate;
import com.example.classifier_final_project.service.dto.concerts.ConcertToRead;
import com.example.classifier_final_project.service.exceptions.PageSizeIndexException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConcertController implements IConcertController {

    private final IConcertService concertService;

    @Autowired
    public ConcertController(IConcertService concertService) {
        this.concertService = concertService;
    }

    @Override
    public ResponseEntity<ConcertToCreate> create(ConcertToCreate classifier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(concertService.create(classifier));
    }

    @Override
    public ResponseEntity<PageToReadClassifier<ConcertToRead>> getPageOfClassifier(Integer size, Integer page) {
        if (page<=0||size<=0) {
            throw new PageSizeIndexException(page,size);
        }
        return ResponseEntity.ok(concertService.getPageOfClassifier(size, page));
    }

    @Override
    public ResponseEntity<Boolean> searchByUUID(String uuid) {
        return ResponseEntity.ok(concertService.searchByUuid(uuid));
    }

}
