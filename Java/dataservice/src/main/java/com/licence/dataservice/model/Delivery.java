package com.licence.dataservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Delivery {
    private Integer deliveryId;
    private float longitude;
    private float latitude;
    private Integer driverId;
    private Integer warehouseID;
}
