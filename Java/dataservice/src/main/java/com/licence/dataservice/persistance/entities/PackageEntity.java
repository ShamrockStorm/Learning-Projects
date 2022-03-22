package com.licence.dataservice.persistance.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tpackage")
public class PackageEntity {
    @Id
    @Column(name = "packageid")
    private Integer packageId;
    @Column(name = "itemname")
    private String itemName;
    @Column(name = "dropofflongitude")
    private float dropOffLongitude;
    @Column(name = "dropofflatitude")
    private float dropOffLatitude;
    @Column(name = "userid")
    private Integer UserId;
    @Column(name = "deliveryid")
    private Integer DeliveryId;

    @ManyToOne
    @JoinColumn (name = "userid")
    private UserEntity user;

    @ManyToOne
    @JoinColumn (name = "deliveryid")
    private DeliveryEntity delivery;
}
