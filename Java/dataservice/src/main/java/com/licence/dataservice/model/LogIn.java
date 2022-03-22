package com.licence.dataservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogIn {
    private Integer logInId;
    private String username;
    private String email;
    private String logInType;
    private String hashedPassword;
    private String hashSalt;
}
