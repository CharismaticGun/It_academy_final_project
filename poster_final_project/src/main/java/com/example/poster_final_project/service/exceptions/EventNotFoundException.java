package com.example.poster_final_project.service.exceptions;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

public class EventNotFoundException extends EntityNotFoundException {

    public EventNotFoundException(UUID uuid){
        super("Event with such uuid " + uuid+ " not found. Check uuid.");
    }
 }
