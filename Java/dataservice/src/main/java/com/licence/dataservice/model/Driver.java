package com.licence.dataservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Driver {
    private Integer driverId;
    private String driverFirstName;
    private String driverLastName;
    private Integer logInId;
    //private LogIn logIn;
}
