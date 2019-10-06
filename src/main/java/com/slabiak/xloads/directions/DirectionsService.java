package com.slabiak.xloads.directions;

import com.slabiak.xloads.geocoding.GeocodingApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class DirectionsService {
    private String apiUrl;
    private RestTemplate restTemplate;

    public DirectionsService(@Value("${google.directions.api.url}") String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    public DirectionsApiResponse resolveTimeDistance(GeocodingApiResponse origin, GeocodingApiResponse destination) {
        String requestUrl = buildRequestUrl(origin, destination);
        log.info("Calling google API Directions service with url {}", requestUrl);
        return restTemplate.getForObject(requestUrl, DirectionsApiResponse.class);
    }


    String buildRequestUrl(GeocodingApiResponse origin, GeocodingApiResponse destination) {
        return apiUrl.replace("ORIGIN", origin.toString()).replace("DESTINATION", destination.toString());
    }
}
