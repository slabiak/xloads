package com.slabiak.xloads.directions;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class DirectionsApiResponseDeserializer extends StdDeserializer<DirectionsApiResponse> {

    public DirectionsApiResponseDeserializer() {
        this(DirectionsApiResponse.class);
    }

    protected DirectionsApiResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DirectionsApiResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int distance = (Integer) node.get("routes").get(0).get("legs").get(0).get("distance").get("value").asInt();
        int duration = (Integer) node.get("routes").get(0).get("legs").get(0).get("duration").get("value").asInt();
        return new DirectionsApiResponse(distance, duration);
    }
}
