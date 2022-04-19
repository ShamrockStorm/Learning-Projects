package com.licence.dataservice.services;

import com.licence.dataservice.model.PackageModel;
import com.licence.dataservice.persistance.entities.DeliveryEntity;
import com.licence.dataservice.persistance.entities.PackageEntity;
import com.licence.dataservice.persistance.entities.WarehouseEntity;
import com.licence.dataservice.persistance.repositories.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class PackageService {
    PackageRepository packageRepository;
    UserRepository userRepository;
    DeliveryRepository deliveryRepository;
    WarehouseRepository warehouseRepository;
    DriverRepository driverRepository;
    public PackageService(PackageRepository packageRepository, UserRepository userRepository, DeliveryRepository deliveryRepository,
                          WarehouseRepository warehouseRepository, DriverRepository driverRepository){
        this.packageRepository = packageRepository;
        this.userRepository = userRepository;
        this.deliveryRepository = deliveryRepository;
        this.warehouseRepository = warehouseRepository;
        this.driverRepository = driverRepository;
    }

    public PackageModel insertPackage (PackageModel pack){
        PackageEntity packageEntity = new PackageEntity();
        //packageEntity.setPackageId(pack.getPackageId());
        packageEntity.setProgress(pack.getProgress());
        packageEntity.setDropOffLatitude(pack.getDropOffLatitude());
        packageEntity.setDropOffLongitude(pack.getDropOffLongitude());
        packageEntity.setDropOffRange(pack.getDropOffRange());
        packageEntity.setItemName(pack.getItemName());
        int deliveryId = (int)deliveryRepository.count();
        DeliveryEntity deliveryEntity;
        while(deliveryId > 0 && !deliveryRepository.getById(deliveryId).getProgress().equals("Building")) {
            deliveryId --;
        }
        if(deliveryId == 0) {
            deliveryEntity = new DeliveryEntity();
            Integer wareId = (int)Math.round(Math.random()*warehouseRepository.count());
            Integer driverId = (int)Math.round(Math.random()*driverRepository.count());
            WarehouseEntity warehouseEntity = warehouseRepository.getById(wareId);
            deliveryEntity.setWarehouse(warehouseEntity);
            deliveryEntity.setDriver(driverRepository.getById(driverId));
            deliveryEntity.setNumberOfPackages(0);
            deliveryEntity.setProgress("Building");
            deliveryEntity.setLongitude(warehouseEntity.getLongitude());
            deliveryEntity.setLatitude(warehouseEntity.getLatitude());
        }
        else{
            deliveryEntity = deliveryRepository.getById(deliveryId);
        }
        int noPack = deliveryEntity.getNumberOfPackages();
        deliveryEntity.setNumberOfPackages(noPack+1);
        noPack++;
        if(noPack >= 10) deliveryEntity.setProgress("Warehouse");
        deliveryRepository.save(deliveryEntity);
        System.out.println(deliveryEntity.toString());
        packageEntity.setDelivery(deliveryEntity);
        packageEntity.setDelivery(deliveryRepository.getById(pack.getDeliveryId()));
        packageEntity.setUser(userRepository.getById(pack.getUserId()));
        System.out.println(packageEntity.toString());
        packageRepository.save(packageEntity);
        return pack;
    }

    public List<PackageModel> getAllPackages(){
        return packageRepository.findAll().stream().map(packageEntity -> PackageModel.builder()
                .packageId(packageEntity.getPackageId())
                .dropOffLatitude(packageEntity.getDropOffLatitude())
                .dropOffLongitude(packageEntity.getDropOffLongitude())
                .dropOffRange(packageEntity.getDropOffRange())
                .progress(packageEntity.getProgress())
                .itemName(packageEntity.getItemName())
                .deliveryId(packageEntity.getDelivery().getDeliveryId())
                .userId(packageEntity.getUser().getUserId())
                .build())
                .collect(Collectors.toList());
    }
}
