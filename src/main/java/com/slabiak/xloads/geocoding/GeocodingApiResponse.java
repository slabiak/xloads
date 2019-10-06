package com.slabiak.xloads.geocoding;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonDeserialize(using = ApiResponseDeserializer.class)
public class GeocodingApiResponse {
    String lng;
    String lat;

    @Override
    public String toString() {
        return lng + "," + lat;
    }
}
