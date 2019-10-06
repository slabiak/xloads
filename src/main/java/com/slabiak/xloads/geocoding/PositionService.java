package com.slabiak.xloads.geocoding;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PositionService {

    private String apiUrl;
    private RestTemplate restTemplate;

    public PositionService(@Value("${google.geocoding.api.url}") String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    public GeocodingApiResponse resolvePosition(Address address) {
        return restTemplate.getForObject(buildRequestUrl(address), GeocodingApiResponse.class);
    }

    private String buildRequestUrl(Address address) {
        return apiUrl.replace("ADDRESS", address.toString());
    }
}
