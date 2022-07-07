package com.example.poster_final_project.service.mappers;

import com.example.poster_final_project.dao.entity.EventFilm;
import com.example.poster_final_project.dao.enums.EventStatus;
import com.example.poster_final_project.service.api.DTOMapper;
import com.example.poster_final_project.service.dto.films.EventFilmToCreate;
import com.example.poster_final_project.service.dto.films.EventFilmsToRead;
import com.example.poster_final_project.service.dto.films.PageEventFilmsToShow;
import com.example.poster_final_project.service.exceptions.CountryNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.reactive.function.client.WebClient;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.UUID;


public class EventFilmsMapper implements DTOMapper<EventFilm, EventFilmToCreate,EventFilmsToRead, PageEventFilmsToShow> {

    private final ModelMapper mapper;

    private final WebClient webClient;

    @Autowired
    public EventFilmsMapper(ModelMapper mapper, WebClient webClient) {
        this.mapper = mapper;
        this.webClient = webClient;
    }

    @Override
    public EventFilm fromDTOToEntity(EventFilmToCreate dto) {
        EventFilm eventFilm = mapper.map(dto,EventFilm.class);
        if (Boolean.FALSE.equals(checkCountry(eventFilm.getCountry().toString()))) {
            throw new CountryNotFoundException(eventFilm.getCountry());
        }
        eventFilm.setUuid(UUID.randomUUID());
        eventFilm.setDtCreate(LocalDateTime.now());
        eventFilm.setDtUpdate(eventFilm.getDtCreate());
        return eventFilm;
    }

    @Override
    public EventFilmsToRead fromEntityToDTO(EventFilm entity) {
        return mapper.map(entity,EventFilmsToRead.class);
    }

    @Override
    public PageEventFilmsToShow fromEntityPageToDtoPage(Page<EventFilm> eventFilms) {
        PageEventFilmsToShow pageEventFilmsToShow = mapper.map(eventFilms, PageEventFilmsToShow.class);
        pageEventFilmsToShow.setNumber(pageEventFilmsToShow.getNumber()+1);
        return pageEventFilmsToShow;
    }

    @Override
    public void updateEntityFromDTO(EventFilmToCreate dto, EventFilm entity) {
        entity.setReleaseYear(dto.getReleaseYear());
        entity.setReleaseDate(dto.getReleaseDate());
        entity.setDuration(dto.getDuration());
        entity.setDescription(dto.getDescription());
        entity.setStatus(EventStatus.valueOf(dto.getStatus()));
        entity.setTitle(dto.getTitle());
        entity.setCountry(dto.getCountry());
        entity.setDtEvent(dto.getDtEvent());
        entity.setDtEndOfSale(dto.getDtEndOfSale());
    }

    private Boolean checkCountry(final String uuid) {
        return webClient.get().uri(String.join
                ("","/country/",uuid))
                .retrieve().bodyToMono(Boolean.class).block();
    }
}
