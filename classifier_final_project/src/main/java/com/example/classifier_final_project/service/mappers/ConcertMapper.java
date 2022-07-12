package com.example.classifier_final_project.service.mappers;

import com.example.classifier_final_project.dao.entity.ConcertCategory;
import com.example.classifier_final_project.service.api.DTOMapper;
import com.example.classifier_final_project.service.dto.PageToReadClassifier;
import com.example.classifier_final_project.service.dto.concerts.ConcertToCreate;
import com.example.classifier_final_project.service.dto.concerts.ConcertToRead;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.UUID;

public class ConcertMapper implements DTOMapper<ConcertCategory,
        ConcertToCreate, ConcertToRead, PageToReadClassifier<ConcertToRead>> {

    private final ModelMapper mapper;

    @Autowired
    public ConcertMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public ConcertCategory fromDtoToEntity(ConcertToCreate dtoToCreate) {
        ConcertCategory concertCategory = mapper.map(dtoToCreate,ConcertCategory.class);
        concertCategory.setUuid(UUID.randomUUID());
        concertCategory.setDtCreate(LocalDateTime.now());
        concertCategory.setDtUpdate(concertCategory.getDtCreate());
        return concertCategory;
    }

    @Override
    public ConcertToRead fromEntityToDto(ConcertCategory classifier) {
        return mapper.map(classifier,ConcertToRead.class);
    }

    @Override
    public PageToReadClassifier<ConcertToRead> fromEntityPageToDtoPage(Page<ConcertCategory> concertCategories) {
        PageToReadClassifier<ConcertToRead> pageToReadClassifier = mapper.map(concertCategories, PageToReadClassifier.class);
        pageToReadClassifier.setNumber(pageToReadClassifier.getNumber()+1);
        return pageToReadClassifier;
    }
}
