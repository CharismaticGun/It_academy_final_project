package com.example.classifier_final_project.controllers.api;

import com.example.classifier_final_project.service.dto.api.IPage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/classifier")
public interface IClassifierController<C, P extends IPage<?>> {

    ResponseEntity<C> create(C classifier);

    ResponseEntity<P> getPageOfClassifier(Integer size, Integer page);

    ResponseEntity<Boolean> searchByUUID(String uuid);
}
