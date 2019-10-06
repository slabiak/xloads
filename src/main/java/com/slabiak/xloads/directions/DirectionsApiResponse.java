package com.slabiak.xloads.directions;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@JsonDeserialize(using = DirectionsApiResponseDeserializer.class)
public class DirectionsApiResponse {

    int distance;
    int time;
}
