package com.slabiak.xloads.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AdvertisementNotFoundException extends RuntimeException {

    public AdvertisementNotFoundException(String message) {
        super(message);
    }
}
