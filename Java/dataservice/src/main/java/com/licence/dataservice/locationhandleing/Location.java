package com.licence.dataservice.locationhandleing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Location {
    double lng;
    double lat;

    public Location(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }
    public Location(){}
    //String address;

}
