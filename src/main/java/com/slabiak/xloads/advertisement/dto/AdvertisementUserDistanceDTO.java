package com.slabiak.xloads.advertisement.dto;

import com.slabiak.xloads.directions.DirectionsApiResponse;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AdvertisementUserDistanceDTO {

    private DirectionsApiResponse distance;
    private AdvertisementReadDTO advertisement;
}
