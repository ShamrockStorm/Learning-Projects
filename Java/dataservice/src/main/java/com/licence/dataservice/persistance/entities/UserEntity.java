package com.licence.dataservice.persistance.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tusers")
public class UserEntity {
    @Id
    @Column(name = "userid")
    private Integer userId;
    @Column(name = "userfirstname")
    private String userFirstName;
    @Column(name = "userlastname")
    private String userLastName;
    @Column(name = "useradress")
    private String userAdress;
    @Column(name = "latitude")
    private float latitude;
    @Column(name = "longitude")
    private float longitude;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="loginid")
    private LogInEntity logIn;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "userid")
    //List<PackageEntity> packages = new ArrayList<PackageEntity>();
}
