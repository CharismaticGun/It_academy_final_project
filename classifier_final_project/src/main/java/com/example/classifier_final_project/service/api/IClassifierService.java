package com.example.classifier_final_project.service.api;


import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface IClassifierService<C,R> {

    @Transactional()
    C create(C classifier);

    R getPageOfClassifier(Integer size, Integer page);

    Boolean searchByUuid(String uuid);

}
