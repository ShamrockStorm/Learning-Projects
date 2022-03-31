package com.licence.dataservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PackageModel {
    private Integer packageId;
    private String itemName;
    private float dropOffLongitude;
    private float dropOffLatitude;
    private Integer dropOffRange;
    private String progress;
    private Integer userId;
    private Integer deliveryId;
    //private User user;
    //private Delivery delivery;
}
