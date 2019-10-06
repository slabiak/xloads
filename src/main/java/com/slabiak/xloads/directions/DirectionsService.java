package com.slabiak.xloads.directions;

import com.slabiak.xloads.geocoding.AddressPosition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DirectionsService {
    private String apiUrl;
    private RestTemplate restTemplate;

    public DirectionsService(@Value("${google.directions.api.url}") String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    public DirectionsApiResponse resolveTimeDistance(AddressPosition origin, AddressPosition destination) {
        return restTemplate.getForObject(buildRequestUrl(origin, destination), DirectionsApiResponse.class);
    }


    String buildRequestUrl(AddressPosition origin, AddressPosition destination) {
        return apiUrl.replace("ORIGIN", origin.toString()).replace("DESTINATION", destination.toString());
    }
}
