package com.licence.dataservice.controllers;

import com.licence.dataservice.model.Delivery;
import com.licence.dataservice.persistance.entities.DeliveryEntity;
import com.licence.dataservice.persistance.updatehelpers.DeliveryUpdateHelper;
import com.licence.dataservice.services.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveryController {
    private DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping(path= "/delivery")
    public ResponseEntity<List<Delivery>> getAllDeliveries(){
        return new ResponseEntity(deliveryService.getAllDeliveries(), HttpStatus.OK);
    }

    @PutMapping(path="/deliveryUpdate")
    public ResponseEntity<DeliveryEntity> updateDeliveryLocation(@RequestBody DeliveryUpdateHelper delivery){
        return new ResponseEntity(deliveryService.updateLocation(delivery.getLatitude(), delivery.getLongitude(),delivery.getDeliveryId()),HttpStatus.OK);
    }



}
