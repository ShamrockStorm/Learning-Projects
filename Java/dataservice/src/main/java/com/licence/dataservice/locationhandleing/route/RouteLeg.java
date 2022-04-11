package com.licence.dataservice.locationhandleing.route;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.licence.dataservice.locationhandleing.Location;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class RouteLeg {
    RouteDistance distance;
    String status;
    @JsonIgnore
    String duration;
    String end_address;
    Location end_location;
    String start_address;
    Location start_location;
    @JsonIgnore
    String steps;
    @JsonIgnore
    String traffic_speed_entry;
    @JsonIgnore
    String via_waypoint;
}
