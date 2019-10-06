package com.slabiak.xloads.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class GoogleApiNotAvailableException extends RuntimeException {
    public GoogleApiNotAvailableException(String message) {
        super(message);
    }

}
