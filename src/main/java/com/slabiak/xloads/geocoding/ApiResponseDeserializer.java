package com.slabiak.xloads.geocoding;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.slabiak.xloads.directions.DirectionsNotFoundException;

import java.io.IOException;

public class ApiResponseDeserializer extends StdDeserializer<GeocodingApiResponse> {

    public ApiResponseDeserializer() {
        this(GeocodingApiResponse.class);
    }

    protected ApiResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public GeocodingApiResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        if (node.get("status").asText().equals("OK")) {
            String lat = node.get("results").get(0).get("geometry").get("location").get("lat").asText();
            String lng = node.get("results").get(0).get("geometry").get("location").get("lng").asText();
            return new GeocodingApiResponse(lat, lng);
        } else {
            String errorMessage;
            if (node.has("error_message")) {
                errorMessage = node.get("error_message").asText();
            } else {
                errorMessage = "NO_MESSAGE";
            }
            throw new DirectionsNotFoundException("Provided address couldn't be geocoded by Google Geolocations API, detailed message: " + errorMessage);
        }
    }
}
