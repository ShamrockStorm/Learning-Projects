package com.licence.dataservice.persistance.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tpackages")
public class PackageEntity {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "packageid", unique = true, nullable = false)
    private Integer packageId;
    @Column(name = "itemname")
    private String itemName;
    @Column(name = "dropofflongitude")
    private float dropOffLongitude;
    @Column(name = "dropofflatitude")
    private float dropOffLatitude;
    @Column(name="dropoffrange")
    private Integer dropOffRange;
    @Column(name="progress")
    private String progress;

    @ManyToOne
    @JoinColumn (name = "userid")
    private UserEntity user;

    @ManyToOne
    @JoinColumn (name = "deliveryid")
    private DeliveryEntity delivery;
}
