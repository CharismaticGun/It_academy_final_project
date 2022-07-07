package com.example.classifier_final_project.service;

import com.example.classifier_final_project.dao.entity.Country;
import com.example.classifier_final_project.dao.repositories.CountryRepository;
import com.example.classifier_final_project.service.dto.PageToReadCountry;
import com.example.classifier_final_project.service.dto.countries.CountryToCreate;
import com.example.classifier_final_project.service.api.ICountryService;
import com.example.classifier_final_project.service.mappers.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CountryService implements ICountryService {


    private final CountryRepository countryRepository;

    private final CountryMapper mapper;

    @Autowired
    public CountryService(CountryRepository countryRepository, CountryMapper mapper) {
        this.countryRepository = countryRepository;
        this.mapper = mapper;
    }

    @Override
    public CountryToCreate create(CountryToCreate classifier) {
        Country country = mapper.fromDtoToEntity(classifier);
        countryRepository.saveAndFlush(country);
        return classifier;
    }

    @Override
    public PageToReadCountry getPageOfClassifier(Integer size, Integer page) {

        Page<Country> entityRead = countryRepository.findAll(PageRequest.of(
                --page, size, Sort.by(Sort.Direction.ASC, "title")));

        return mapper.fromEntityPageToDtoPage(entityRead);
    }

    @Override
    public Boolean searchByUuid(String uuid) {
        Optional<Country> country = countryRepository.searchByUuid(UUID.fromString(uuid));
        return country.isPresent();
    }
}
