package com.example.classifier_final_project.service.mappers;

import com.example.classifier_final_project.dao.entity.Country;
import com.example.classifier_final_project.service.api.DTOMapper;
import com.example.classifier_final_project.service.dto.PageToReadCountry;
import com.example.classifier_final_project.service.dto.countries.CountryToCreate;
import com.example.classifier_final_project.service.dto.countries.CountryToRead;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.UUID;

public class CountryMapper implements DTOMapper<Country, CountryToCreate, CountryToRead, PageToReadCountry> {

    private final ModelMapper mapper;

    @Autowired
    public CountryMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Country fromDtoToEntity(CountryToCreate dtoToCreate) {
        Country country = mapper.map(dtoToCreate,Country.class);
        country.setUuid(UUID.randomUUID());
        country.setDtCreate(LocalDateTime.now());
        country.setDtUpdate(country.getDtCreate());
        return country;
    }

    @Override
    public CountryToRead fromEntityToDto(Country classifier) {
        return mapper.map(classifier,CountryToRead.class);
    }

    @Override
    public PageToReadCountry fromEntityPageToDtoPage(Page<Country> countries) {
        PageToReadCountry pageToReadCountry = mapper.map(countries,PageToReadCountry.class);
        pageToReadCountry.setNumber(pageToReadCountry.getNumber()+1);
        return pageToReadCountry;
    }
}
