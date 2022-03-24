package com.licence.dataservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Integer userId;
    private String userFirstName;
    private String userLastName;
    private String userAdress;
    private float latitude;
    private float longitude;
    private Integer deliveryRange;
    private LogIn logIn;
}
