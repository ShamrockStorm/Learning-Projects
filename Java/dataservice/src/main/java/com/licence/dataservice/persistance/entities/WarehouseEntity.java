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
@Table(name = "twarehouse")
public class WarehouseEntity {
    @Id
    @Column(name = "warehouseid")
    private Integer warehouseId;
    @Column(name = "warehousename")
    private String warehouseName;
    @Column(name = "warehouseadress")
    private String warehouseAdress;
    @Column(name = "latitude")
    private float latitude;
    @Column(name = "longitude")
    private float longitude;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "warehouseid")
    //List<DeliveryEntity> deliveries = new ArrayList<DeliveryEntity>();
}
