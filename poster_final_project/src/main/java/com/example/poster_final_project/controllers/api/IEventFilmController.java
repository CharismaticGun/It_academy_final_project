package com.example.poster_final_project.controllers.api;


import com.example.poster_final_project.service.dto.PageToReadEvent;
import com.example.poster_final_project.service.dto.concerts.EventConcertToRead;
import com.example.poster_final_project.service.dto.films.EventFilmToCreate;
import com.example.poster_final_project.service.dto.films.EventFilmsToRead;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/afisha/event/films")
public interface IEventFilmController extends IEventController<EventFilmToCreate, EventFilmsToRead,
        PageToReadEvent<EventFilmsToRead>>{

    @Override
    @PostMapping
    ResponseEntity<EventFilmToCreate> createEvent(@RequestBody EventFilmToCreate dtoEvent);

    @Override
    @GetMapping("/{uuid}")
    ResponseEntity<EventFilmsToRead> readEventInfo(@PathVariable String uuid);

    @Override
    @PutMapping("/{uuid}/dt_update/{dt_update}")
    ResponseEntity<EventFilmToCreate> updateEvent(@RequestBody EventFilmToCreate dtoEvent,
                                                  @PathVariable String uuid,
                                                  @PathVariable(name = "dt_update") Long dtUpdate);

    @Override
    @GetMapping
    ResponseEntity<PageToReadEvent<EventFilmsToRead>> readEventPage(
            @RequestParam(required = false,defaultValue = "25",name = "size")Integer size,
            @RequestParam(required = false,defaultValue = "1",name = "page") Integer page);
}
