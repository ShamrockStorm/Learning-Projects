package com.licence.dataservice.locationhandleing.route;

import com.licence.dataservice.locationhandleing.Location;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Route implements Comparable<Route> {
    Location origin;
    Location destination;
    Double length;

    @Override
    public int compareTo(@NotNull Route route) {
        if(this.length == route.getLength()) return 0;
        else{
            if(this.length > route.getLength()) return 1;
            else return -1;
        }
    }
}
