package com.example.poster_final_project.controllers;

import com.example.poster_final_project.controllers.api.IEventFilmController;
import com.example.poster_final_project.dao.enums.EventType;
import com.example.poster_final_project.service.api.IEventFilmService;
import com.example.poster_final_project.service.dto.PageToReadEvent;
import com.example.poster_final_project.service.dto.films.EventFilmToCreate;
import com.example.poster_final_project.service.dto.films.EventFilmsToRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
public class EventFilmsController implements IEventFilmController {

    private final IEventFilmService service;

    @Autowired
    public EventFilmsController(IEventFilmService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<EventFilmToCreate> createEvent(EventFilmToCreate dtoEvent) {
        dtoEvent.setType(EventType.FILMS);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dtoEvent));
    }

    @Override
    public ResponseEntity<EventFilmsToRead> readEventInfo(String uuid) {
        return ResponseEntity.ok(service.readEventInfo(uuid));
    }

    @Override
    public ResponseEntity<EventFilmToCreate> updateEvent(EventFilmToCreate dtoEvent, String uuid, Long dtUpdate) {
        dtoEvent.setType(EventType.FILMS);
        LocalDateTime lastDateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());
        return ResponseEntity.ok(service.updateEventInfo(dtoEvent,uuid,lastDateUpdate));
    }

    @Override
    public ResponseEntity<PageToReadEvent<EventFilmsToRead>> readEventPage(Integer size, Integer page) {
        return ResponseEntity.ok(service.readEventPage(size, page));
    }
}
