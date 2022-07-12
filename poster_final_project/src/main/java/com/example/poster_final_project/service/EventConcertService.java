package com.example.poster_final_project.service;

import com.example.poster_final_project.dao.entity.EventConcert;
import com.example.poster_final_project.dao.enums.EventStatus;
import com.example.poster_final_project.dao.repositories.EventConcertRepository;
import com.example.poster_final_project.service.api.IEventConcertService;
import com.example.poster_final_project.service.dto.PageToReadEvent;
import com.example.poster_final_project.service.dto.concerts.EventConcertToCreate;
import com.example.poster_final_project.service.dto.concerts.EventConcertToRead;
import com.example.poster_final_project.service.exceptions.EventNotFoundException;
import com.example.poster_final_project.service.mappers.EventConcertMapper;
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
public class EventConcertService implements IEventConcertService {

    private final EventConcertRepository eventConcertRepository;

    private final EventConcertMapper eventConcertMapper;

    @Autowired
    public EventConcertService(EventConcertRepository eventConcertRepository, EventConcertMapper eventConcertMapper) {
        this.eventConcertRepository = eventConcertRepository;
        this.eventConcertMapper = eventConcertMapper;
    }

    @Override
    public EventConcertToCreate create(EventConcertToCreate event) {

        if (event.getStatus()==null) {
            event.setStatus(String.valueOf(EventStatus.DRAFT));
        } else {
            event.setStatus(event.getStatus().toUpperCase(Locale.ROOT));
        }

        EventConcert concert = eventConcertMapper.fromDTOToEntity(event);

        eventConcertRepository.save(concert);

        return event;
    }

    @Override
    public EventConcertToRead readEventInfo(String uuid) {
        EventConcert eventConcert = eventConcertRepository.findById(UUID.fromString(uuid))
                .orElseThrow(()->new EventNotFoundException(UUID.fromString(uuid)));
        return eventConcertMapper.fromEntityToDTO(eventConcert);
    }

    @Override
    public EventConcertToCreate updateEventInfo(EventConcertToCreate event, String uuid, LocalDateTime dtUpdate) {
        if (event.getStatus()==null) {
            event.setStatus(String.valueOf(EventStatus.DRAFT));
        } else {
            event.setStatus(event.getStatus().toUpperCase(Locale.ROOT));
        }
        EventConcert eventConcert = eventConcertRepository.findById(UUID.fromString(uuid)).
                orElseThrow(()->new EventNotFoundException(UUID.fromString(uuid)));

        eventConcertMapper.updateEntityFromDTO(event,eventConcert);
        if (eventConcert.getDtUpdate().equals(dtUpdate)) {
            eventConcertRepository.save(eventConcert);
        } else {
            throw new OptimisticLockException("Event already updated");
        }
        return event;
    }

    @Override
    public PageToReadEvent<EventConcertToRead> readEventPage(int size, int page) {
        Page<EventConcert> pageEntity = eventConcertRepository.findAll(PageRequest.of(
                --page, size, Sort.Direction.ASC, "title"));
        return eventConcertMapper.fromEntityPageToDtoPage(pageEntity);
    }
}
