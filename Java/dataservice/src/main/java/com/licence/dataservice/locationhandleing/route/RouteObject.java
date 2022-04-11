package com.licence.dataservice.locationhandleing.route;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class RouteObject {
    List<RouteLeg> legs;
    String status;
    String copyrights;
    RouteBound bounds;
    @JsonIgnore
    String overview_polyline;
    @JsonIgnore
    String summary;
    @JsonIgnore
    String warnings;
    @JsonIgnore
    String waypoint_order;
}
