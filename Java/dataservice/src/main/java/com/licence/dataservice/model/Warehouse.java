package com.licence.dataservice.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Warehouse {
    private Integer warehouseId;
    private String warehouseName;
    private String warehouseAdress;
    private Integer pickUpRange;
    private float latitude;
    private float longitude;
}
