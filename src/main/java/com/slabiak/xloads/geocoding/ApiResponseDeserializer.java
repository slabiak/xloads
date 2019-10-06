package com.slabiak.xloads.geocoding;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ApiResponseDeserializer extends StdDeserializer<ApiResponse> {

    public ApiResponseDeserializer() {
        this(ApiResponse.class);
    }

    protected ApiResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ApiResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String lat = (String) node.get("results").get(0).get("geometry").get("location").get("lat").asText();
        String lng = (String) node.get("results").get(0).get("geometry").get("location").get("lng").asText();

        return new ApiResponse(lat, lng);
    }
}
