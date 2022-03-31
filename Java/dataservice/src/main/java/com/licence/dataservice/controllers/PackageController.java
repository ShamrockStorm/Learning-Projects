package com.licence.dataservice.controllers;

import com.licence.dataservice.model.PackageModel;
import com.licence.dataservice.services.PackageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageController {
    private PackageService packageService;

    public PackageController(PackageService packageService){this.packageService = packageService;}

    @PostMapping(path = "/packageInsert")
    public ResponseEntity<PackageModel> insertPackage(@RequestBody PackageModel pack){
        return new ResponseEntity<>(packageService.insertPackage(pack),HttpStatus.OK);
    }

    @GetMapping(path = "/package")
    public ResponseEntity<List<PackageModel>> getAllPackages(){
        return new ResponseEntity<>(packageService.getAllPackages(),HttpStatus.OK);
    }
}
