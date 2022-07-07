package com.example.poster_final_project.service;

import com.example.poster_final_project.dao.entity.EventFilm;
import com.example.poster_final_project.dao.enums.EventStatus;
import com.example.poster_final_project.dao.repositories.EventFilmRepository;
import com.example.poster_final_project.service.api.IEventFilmService;
import com.example.poster_final_project.service.api.IEventService;
import com.example.poster_final_project.service.dto.films.EventFilmToCreate;
import com.example.poster_final_project.service.dto.films.EventFilmsToRead;
import com.example.poster_final_project.service.dto.films.PageEventFilmsToShow;
import com.example.poster_final_project.service.exceptions.EventNotFoundException;
import com.example.poster_final_project.service.mappers.EventFilmsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.persistence.OptimisticLockException;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;


@Service
public class EventFilmService implements IEventFilmService {

    private final EventFilmRepository repository;

    private final EventFilmsMapper mapper;


    @Autowired
    public EventFilmService(EventFilmRepository eventRepository, EventFilmsMapper mapper) {
        this.repository = eventRepository;
        this.mapper = mapper;
    }


    @Override
    public EventFilmToCreate create(EventFilmToCreate event) {
        if (event.getStatus()==null) {
            event.setStatus(String.valueOf(EventStatus.DRAFT));
        } else {
            event.setStatus(event.getStatus().toUpperCase(Locale.ROOT));
        }
        EventFilm eventFilm = mapper.fromDTOToEntity(event);
        repository.save(eventFilm);
        return event;
    }

    @Override
    public EventFilmsToRead readEventInfo(String uuid) {
        EventFilm eventFilm = repository.findById(UUID.fromString(uuid)).
                orElseThrow(()-> new EventNotFoundException(UUID.fromString(uuid)));
        return mapper.fromEntityToDTO(eventFilm);
    }

    @Override
    public EventFilmToCreate updateEventInfo(EventFilmToCreate event, String uuid, LocalDateTime dtUpdate) {

        if (event.getStatus()==null) {
            event.setStatus(String.valueOf(EventStatus.DRAFT));
        } else {
            event.setStatus(event.getStatus().toUpperCase(Locale.ROOT));
        }
       EventFilm eventFilm = repository.findById(UUID.fromString(uuid)).
               orElseThrow(()->new EventNotFoundException(UUID.fromString(uuid)));

            if (eventFilm.getDtUpdate().equals(dtUpdate)) {
                mapper.updateEntityFromDTO(event,eventFilm);
                repository.save(eventFilm);
            } else {
                throw new OptimisticLockException("Entity already updated");
            }
            return event;
        }

    @Override
    public PageEventFilmsToShow readEventPage(int size, int page) {
        Page<EventFilm> title = repository.findAll(PageRequest.of(--page, size, Sort.by(Sort.Direction.ASC, "title")));
        return mapper.fromEntityPageToDtoPage(title);
    }
}
