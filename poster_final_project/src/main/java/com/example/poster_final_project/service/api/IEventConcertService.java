package com.example.poster_final_project.service.api;

import com.example.poster_final_project.service.dto.PageToReadEvent;
import com.example.poster_final_project.service.dto.concerts.EventConcertToCreate;
import com.example.poster_final_project.service.dto.concerts.EventConcertToRead;
import com.example.poster_final_project.service.dto.films.EventFilmsToRead;

public interface IEventConcertService extends IEventService<EventConcertToCreate, EventConcertToRead,
        PageToReadEvent<EventConcertToRead>> {}
