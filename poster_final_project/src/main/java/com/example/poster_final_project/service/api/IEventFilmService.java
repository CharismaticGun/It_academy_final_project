package com.example.poster_final_project.service.api;


import com.example.poster_final_project.service.dto.films.EventFilmToCreate;
import com.example.poster_final_project.service.dto.films.EventFilmsToRead;
import com.example.poster_final_project.service.dto.films.PageEventFilmsToShow;

public interface IEventFilmService extends IEventService<EventFilmToCreate, EventFilmsToRead, PageEventFilmsToShow> {}
