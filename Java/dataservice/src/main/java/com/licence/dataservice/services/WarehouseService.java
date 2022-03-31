package com.licence.dataservice.services;

import com.licence.dataservice.model.Warehouse;
import com.licence.dataservice.persistance.entities.WarehouseEntity;
import com.licence.dataservice.persistance.repositories.WarehouseRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class WarehouseService {
    private WarehouseRepository warehouseRepository;
    public WarehouseService(WarehouseRepository warehouseRepository){
        this.warehouseRepository = warehouseRepository;
    }
    public Warehouse insertWarehouse(Warehouse warehouse){
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setWarehouseId(warehouse.getWarehouseId());
        warehouseEntity.setWarehouseAdress(warehouse.getWarehouseAdress());
        warehouseEntity.setWarehouseName(warehouse.getWarehouseName());
        warehouseEntity.setLongitude(warehouse.getLongitude());
        warehouseEntity.setLatitude(warehouse.getLatitude());
        warehouseEntity.setPickUpRange(warehouse.getPickUpRange());
        warehouseRepository.save(warehouseEntity);
        return  warehouse;
    }

    public List<Warehouse> getAllWarehouses(){
        return warehouseRepository.findAll().stream().map(warehouseEntity -> Warehouse.builder()
                .warehouseId(warehouseEntity.getWarehouseId())
                .warehouseName(warehouseEntity.getWarehouseName())
                .warehouseAdress(warehouseEntity.getWarehouseAdress())
                .latitude(warehouseEntity.getLatitude())
                .longitude(warehouseEntity.getLongitude())
                .pickUpRange(warehouseEntity.getPickUpRange())
        .build()).collect(Collectors.toList());
    }

    public Warehouse updateWarehouse(Warehouse warehouse){
        WarehouseEntity warehouseEntity = warehouseRepository.getById(warehouse.getWarehouseId());
        warehouseEntity.setWarehouseName(warehouse.getWarehouseName());
        warehouseEntity.setWarehouseAdress(warehouse.getWarehouseAdress());
        warehouseEntity.setLatitude(warehouse.getLatitude());
        warehouseEntity.setLongitude(warehouse.getLongitude());
        warehouseEntity.setPickUpRange(warehouse.getPickUpRange());
        warehouseRepository.save(warehouseEntity);
        return  warehouse;
    }

}
