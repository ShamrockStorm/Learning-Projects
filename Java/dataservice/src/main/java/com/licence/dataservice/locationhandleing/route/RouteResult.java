package com.licence.dataservice.locationhandleing.route;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class RouteResult {
    List<RouteObject> routes;
    String status;
    List<GeocodedWaypoint> geocoded_waypoints;

}
