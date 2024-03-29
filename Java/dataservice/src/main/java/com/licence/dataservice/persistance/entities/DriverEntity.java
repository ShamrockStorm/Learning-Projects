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
@Table(name = "tdrivers")
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "driverid", unique = true, nullable = false)
    private Integer driverId;
    @Column(name = "driverfirstname")
    private String driverFirstName;
    @Column(name = "driverlastname")
    private String driverLastName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="loginid")
    private LogInEntity logIn;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "driverid")
    //List<DeliveryEntity> deliveries = new ArrayList<DeliveryEntity>();
}
