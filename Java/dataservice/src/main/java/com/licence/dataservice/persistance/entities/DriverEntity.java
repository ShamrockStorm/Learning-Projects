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
    @Column(name = "driverid")
    private Integer driverId;
    @Column(name = "driverF=firstname")
    private String driverFirstName;
    @Column(name = "driverlastname")
    private String driverLastName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="loginid")
    private LogInEntity logIn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverid")
    List<DeliveryEntity> deliveries = new ArrayList<DeliveryEntity>();
}
