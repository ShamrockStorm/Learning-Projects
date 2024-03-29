package com.licence.dataservice.persistance.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tlogin")
public class LogInEntity {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column (name = "loginid", unique = true, nullable = false)
    private Integer logInId;

    @Column (name = "username")
    private String username;
    @Column (name = "email")
    private String email;
    @Column (name = "logintype")
    private String logInType;
    @Column (name = "hashedpassword")
    private String hashedPassword;
    @Column (name = "hashsalt")
    private String hashSalt;
}
