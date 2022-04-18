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
@Table(name = "tdeliveries")
public class DeliveryEntity {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "deliveryid", unique = true, nullable = false)
    private Integer deliveryId;
    @Column(name = "longitude")
    private float longitude;
    @Column(name = "latitude")
    private float latitude;
    @Column(name="numberofpackages")
    private Integer numberOfPackages;
    @Column(name="progress")
    private String progress;

    @ManyToOne
    @JoinColumn(name = "driverid")
    private DriverEntity driver;

    @ManyToOne
    @JoinColumn (name = "warehouseid")
    private WarehouseEntity warehouse;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "deliveryid")
    //List<PackageEntity> users = new ArrayList<PackageEntity>();
}
