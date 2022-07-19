package com.example.poster_final_project.service.mappers;

import com.example.poster_final_project.dao.entity.EventConcert;
import com.example.poster_final_project.dao.enums.EventStatus;
import com.example.poster_final_project.service.api.DTOMapper;
import com.example.poster_final_project.service.dto.PageToReadEvent;
import com.example.poster_final_project.service.dto.concerts.EventConcertToCreate;
import com.example.poster_final_project.service.dto.concerts.EventConcertToRead;
import com.example.poster_final_project.service.exceptions.ConcertCategoryNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventConcertMapper implements
        DTOMapper<EventConcert, EventConcertToCreate, EventConcertToRead,  PageToReadEvent<EventConcertToRead>> {

    private final ModelMapper modelMapper;

    private final WebClient webClient;

    @Autowired
    public EventConcertMapper(ModelMapper modelMapper, WebClient webClient) {
        this.modelMapper = modelMapper;
        this.webClient = webClient;
    }

    @Override
    public EventConcert fromDTOToEntity(EventConcertToCreate dto) {

        EventConcert concert = modelMapper.map(dto,EventConcert.class);

        if (Boolean.FALSE.equals(checkCategory(concert.getCategory().toString()))&&null!=concert.getCategory()) {
            throw new ConcertCategoryNotFoundException(concert.getCategory());
        }
        concert.setUuid(UUID.randomUUID());
        concert.setDtCreate(LocalDateTime.now());
        concert.setDtUpdate(concert.getDtCreate());

        return concert;
    }

    @Override
    public EventConcertToRead fromEntityToDTO(EventConcert entity) {
        return modelMapper.map(entity,EventConcertToRead.class);
    }

    @Override
    public PageToReadEvent<EventConcertToRead> fromEntityPageToDtoPage(Page<EventConcert> eventConcerts) {
        PageToReadEvent<EventConcertToRead> pageOfConcertToRead = modelMapper.map(eventConcerts, PageToReadEvent.class);
        pageOfConcertToRead.setNumber(pageOfConcertToRead.getNumber()+1);
        return pageOfConcertToRead;
    }

    @Override
    public void updateEntityFromDTO(EventConcertToCreate dto, EventConcert entity) {
        if (null!=dto.getCategory()&&Boolean.FALSE.equals(checkCategory(dto.getCategory().toString()))) {
            throw new ConcertCategoryNotFoundException(dto.getCategory());
        }

        entity.setDtEvent(dto.getDtEvent());
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());
        entity.setStatus(EventStatus.valueOf(dto.getStatus()));
        entity.setDtEndOfSale(dto.getDtEndOfSale());
        entity.setCategory(dto.getCategory());
    }

    private Boolean checkCategory(final String uuid) {
        return webClient.get().uri(String.join
                        ("","/concert/category/",uuid))
                .retrieve().bodyToMono(Boolean.class).block();
    }
}
