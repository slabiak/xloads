package com.slabiak.xloads.directions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DirectionsNotFoundException extends RuntimeException {
    public DirectionsNotFoundException(String message) {
        super(message);
    }
}
