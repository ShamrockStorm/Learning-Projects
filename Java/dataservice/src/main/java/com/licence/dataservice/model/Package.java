package com.licence.dataservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Package {
    private Integer packageId;
    private String itemName;
    private float dropOffLongitude;
    private float dropOffLatitude;
    private Integer dropOffRange;
    private String progress;
    private User user;
    private Delivery delivery;
}
