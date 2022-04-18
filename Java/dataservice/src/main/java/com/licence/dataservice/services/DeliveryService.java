package com.licence.dataservice.services;

import com.licence.dataservice.model.Delivery;
import com.licence.dataservice.persistance.entities.DeliveryEntity;
import com.licence.dataservice.persistance.repositories.DeliveryRepository;
import com.licence.dataservice.persistance.repositories.DriverRepository;
import com.licence.dataservice.persistance.repositories.WarehouseRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class DeliveryService {
    private DeliveryRepository deliveryRepository;
    private DriverRepository driverRepository;
    private WarehouseRepository warehouseRepository;

    public DeliveryService(DeliveryRepository deliveryRepository, DriverRepository driverRepository, WarehouseRepository warehouseRepository) {
        this.deliveryRepository = deliveryRepository;
        this.driverRepository = driverRepository;
        this.warehouseRepository = warehouseRepository;
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll().stream().map(deliveryEntity -> Delivery.builder()
                .deliveryId(deliveryEntity.getDeliveryId())
                .longitude(deliveryEntity.getLongitude())
                .latitude(deliveryEntity.getLatitude())
                .progress(deliveryEntity.getProgress())
                .numberOfPackages(deliveryEntity.getNumberOfPackages())
                .driverId(deliveryEntity.getDriver().getDriverId())
                .warehouseId(deliveryEntity.getWarehouse().getWarehouseId())
                .build())
                .collect(Collectors.toList());
    }

    public Delivery updateLocation(float latitude, float longitude,Integer id){
        DeliveryEntity deliveryEntity = deliveryRepository.getById(id);
        deliveryEntity.setLongitude(longitude);
        deliveryEntity.setLatitude(latitude);
        deliveryRepository.save(deliveryEntity);
        Delivery delivery = Delivery.builder()
                .deliveryId(deliveryEntity.getDeliveryId())
                .longitude(deliveryEntity.getLongitude())
                .latitude(deliveryEntity.getLatitude())
                .numberOfPackages(deliveryEntity.getNumberOfPackages())
                .progress(deliveryEntity.getProgress())
                .driverId(deliveryEntity.getDriver().getDriverId())
                .warehouseId(deliveryEntity.getWarehouse().getWarehouseId())
                .build();
        return delivery;
    }

    public Delivery insertDelivery(Delivery delivery){
        DeliveryEntity deliveryEntity = new DeliveryEntity();
        //deliveryEntity.setDeliveryId(delivery.getDeliveryId());
        deliveryEntity.setLatitude(delivery.getLatitude());
        deliveryEntity.setLongitude(delivery.getLongitude());
        deliveryEntity.setNumberOfPackages(delivery.getNumberOfPackages());
        deliveryEntity.setProgress(delivery.getProgress());
        deliveryEntity.setDriver(driverRepository.getById(delivery.getDriverId()));
        deliveryEntity.setWarehouse(warehouseRepository.getById(delivery.getWarehouseId()));
        deliveryRepository.save(deliveryEntity);
        return delivery;
    }


}
