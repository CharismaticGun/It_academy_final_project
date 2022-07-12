package com.example.poster_final_project.service.api;


import com.example.poster_final_project.service.dto.PageToReadEvent;
import com.example.poster_final_project.service.dto.films.EventFilmToCreate;
import com.example.poster_final_project.service.dto.films.EventFilmsToRead;

public interface IEventFilmService extends IEventService<EventFilmToCreate, EventFilmsToRead, PageToReadEvent<EventFilmsToRead>> {}
