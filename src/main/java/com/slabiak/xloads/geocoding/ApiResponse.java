package com.slabiak.xloads.geocoding;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@JsonDeserialize(using = ApiResponseDeserializer.class)
public class ApiResponse {

    String lng;
    String ltd;
}
