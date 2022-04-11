package com.licence.dataservice.locationhandleing.route;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class RouteDistance {
    String text;
    Integer value;
    String status;
}
