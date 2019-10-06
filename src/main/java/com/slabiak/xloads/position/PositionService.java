package com.slabiak.xloads.position;

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

    public AddressPosition resolvePosition(Address address) {
        ApiResponse apiResponse = restTemplate.getForObject(buildRequestUrl(address), ApiResponse.class);
        return new AddressPosition(apiResponse.getLtd(), apiResponse.getLng());
    }

    private String buildRequestUrl(Address address) {
        return apiUrl.replace("ADDRESS", address.toString());
    }
}
