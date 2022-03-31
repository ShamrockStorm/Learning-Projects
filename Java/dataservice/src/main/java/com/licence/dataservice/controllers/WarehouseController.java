package com.licence.dataservice.controllers;

import com.licence.dataservice.model.Warehouse;
import com.licence.dataservice.services.WarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WarehouseController {
    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }

    @PostMapping(path = "/warehouseInsert")
    public ResponseEntity<Warehouse> insertWarehouse(@RequestBody Warehouse warehouse){
        return new ResponseEntity<>(warehouseService.insertWarehouse(warehouse), HttpStatus.OK);
    }

    @GetMapping(path = "/warehouse")
    public ResponseEntity<List<Warehouse>> getAllWarehouses(){
        return new ResponseEntity<>(warehouseService.getAllWarehouses(), HttpStatus.OK);
    }

    @PutMapping(path = "/updateWarehouse")
    public ResponseEntity<Warehouse> updateWarehouse(Warehouse warehouse){
        return new ResponseEntity<>(warehouseService.updateWarehouse(warehouse), HttpStatus.OK);
    }

}
