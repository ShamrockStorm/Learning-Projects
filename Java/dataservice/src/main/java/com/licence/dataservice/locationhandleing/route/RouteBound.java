package com.licence.dataservice.locationhandleing.route;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.licence.dataservice.locationhandleing.Location;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class RouteBound {
    Location northeast;
    Location southwest;
}
