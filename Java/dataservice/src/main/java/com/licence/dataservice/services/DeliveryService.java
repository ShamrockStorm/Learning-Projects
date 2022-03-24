package com.licence.dataservice.services;

import com.licence.dataservice.model.Delivery;
import com.licence.dataservice.persistance.entities.DeliveryEntity;
import com.licence.dataservice.persistance.repositories.DeliveryRepository;
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

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll().stream().map(deliveryEntity -> Delivery.builder()
                .deliveryId(deliveryEntity.getDeliveryId())
                .longitude(deliveryEntity.getLongitude())
                .build())
                .collect(Collectors.toList());
    }

    public DeliveryEntity updateLocation(float latitude, float longitude,Integer id){
        DeliveryEntity delivery = deliveryRepository.getById(id);
        /*
        List<DeliveryEntity> deliveryList = deliveryRepository.findAll();
        DeliveryEntity delivery = null;
        for(DeliveryEntity deliveryEntity : deliveryList){
            if(deliveryEntity.getDeliveryId()==id) delivery = deliveryEntity;
        }
        */
        delivery.setLongitude(longitude);
        delivery.setLatitude(latitude);
        deliveryRepository.save(delivery);
        return delivery;
    }

}
