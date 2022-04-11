package com.licence.dataservice.locationhandleing.route;

import com.licence.dataservice.locationhandleing.Location;
import lombok.Data;

@Data
public class Route {
    Location origin;
    Location destination;
    Double length;
}
