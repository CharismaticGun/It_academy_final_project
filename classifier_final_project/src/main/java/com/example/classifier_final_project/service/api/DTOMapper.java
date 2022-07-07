package com.example.classifier_final_project.service.api;

import com.example.classifier_final_project.dao.entity.Classifier;
import com.example.classifier_final_project.service.dto.api.IPage;
import org.springframework.data.domain.Page;

public interface DTOMapper<C extends Classifier,D,R,P extends IPage<?>> {

    C fromDtoToEntity(D dtoToCreate);

    R fromEntityToDto(C classifier);

    P fromEntityPageToDtoPage(Page<C> cPage);

}
