package com.example.poster_final_project.service.exceptions;

import java.util.UUID;

public class CountryNotFoundException extends IllegalArgumentException{

    public CountryNotFoundException(UUID uuid) {
        super("Country with such uuid " + uuid + " not found. Check uuid.");
    }
}
