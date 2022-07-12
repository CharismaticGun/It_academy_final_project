package com.example.classifier_final_project.service;


import com.example.classifier_final_project.dao.entity.ConcertCategory;
import com.example.classifier_final_project.dao.repositories.ConcertRepository;
import com.example.classifier_final_project.service.api.IConcertService;
import com.example.classifier_final_project.service.dto.PageToReadClassifier;
import com.example.classifier_final_project.service.dto.concerts.ConcertToCreate;
import com.example.classifier_final_project.service.dto.concerts.ConcertToRead;
import com.example.classifier_final_project.service.mappers.ConcertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;


@Service

public class ConcertService implements IConcertService {

    private final ConcertRepository concertRepository;

    private final ConcertMapper mapper;

    @Autowired
    public ConcertService(ConcertRepository concertRepository, ConcertMapper mapper) {
        this.concertRepository = concertRepository;
        this.mapper = mapper;
    }


    @Override
    public ConcertToCreate create( ConcertToCreate classifier) {

        ConcertCategory concertCategory = mapper.fromDtoToEntity(classifier);

        concertRepository.saveAndFlush(concertCategory);

        return classifier;
    }

    @Override
    public PageToReadClassifier<ConcertToRead> getPageOfClassifier(Integer size, Integer page) {

        Page<ConcertCategory> entityRead = concertRepository.findAll(
                PageRequest.of(--page, size, Sort.by(Sort.Direction.ASC, "title")));

        return mapper.fromEntityPageToDtoPage(entityRead);
    }

    @Override
    public Boolean searchByUuid(String uuid) {
        Optional<ConcertCategory> concertCategory = concertRepository.searchByUuid(UUID.fromString(uuid));
        return concertCategory.isPresent();
    }
}
