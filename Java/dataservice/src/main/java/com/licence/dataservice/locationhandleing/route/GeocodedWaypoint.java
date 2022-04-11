package com.licence.dataservice.locationhandleing.route;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class GeocodedWaypoint {
    String geocoder_status;
    String place_id;
    List<String> types;
}
