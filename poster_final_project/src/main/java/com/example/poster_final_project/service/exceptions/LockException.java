package com.example.poster_final_project.service.exceptions;

import javax.persistence.OptimisticLockException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LockException extends OptimisticLockException {

    private final Map<String,String> exceptionMap;

    public LockException(UUID uuid) {
        super("Event with uuid " + uuid + " already updated");
        this.exceptionMap = new HashMap<>();
        exceptionMap.put("logref","error");
        exceptionMap.put("message",super.getMessage());
    }

    public Map<String, String> getExceptionMap() {
        return exceptionMap;
    }
}
