package com.example.poster_final_project.controllers;

import com.example.poster_final_project.dao.enums.EventType;
import com.example.poster_final_project.service.EventFilmService;
import com.example.poster_final_project.service.api.IEventFilmService;
import com.example.poster_final_project.service.dto.films.EventFilmToCreate;
import com.example.poster_final_project.service.dto.films.EventFilmsToRead;
import com.example.poster_final_project.service.dto.films.PageEventFilmsToShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RequestMapping("/afisha/event")
@RestController
public class EventController {

    private final IEventFilmService service;


    @Autowired
    public EventController(EventFilmService service) {
        this.service = service;
    }


    @PostMapping("/films")
    public ResponseEntity<EventFilmToCreate> create(@RequestBody EventFilmToCreate filmToCreate) {
        filmToCreate.setType(EventType.FILMS);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(filmToCreate));
    }

    @GetMapping("/films/{uuid}")
    public ResponseEntity<EventFilmsToRead> readEventFilmInfo(@PathVariable String uuid) {
        return ResponseEntity.ok(service.readEventInfo(uuid));
    }

    @GetMapping("/films")
    public ResponseEntity<PageEventFilmsToShow> readEventFilmPage(@RequestParam(name = "size",defaultValue = "50") int size,
                                                  @RequestParam(name = "page",defaultValue = "1") int page) {
        return ResponseEntity.ok(service.readEventPage(size, page));
    }

    @PutMapping("/films/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<EventFilmToCreate> updateEventFilmInfo(@RequestBody EventFilmToCreate filmToCreate,
                                                 @PathVariable String uuid,
                                                 @PathVariable(name = "dt_update") Long dtUpdate) {
        filmToCreate.setType(EventType.FILMS);
        LocalDateTime lastDateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());
        return ResponseEntity.ok(service.updateEventInfo(filmToCreate,uuid,lastDateUpdate));
    }

}
