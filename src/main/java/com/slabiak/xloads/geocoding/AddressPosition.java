package com.slabiak.xloads.geocoding;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class AddressPosition {
    private String lat;
    private String lng;

    @Override
    public String toString() {
        return lng + "," + lat;
    }
}
