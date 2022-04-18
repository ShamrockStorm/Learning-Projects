package com.licence.dataservice.services;

import com.licence.dataservice.model.PackageModel;
import com.licence.dataservice.persistance.entities.DeliveryEntity;
import com.licence.dataservice.persistance.entities.PackageEntity;
import com.licence.dataservice.persistance.repositories.DeliveryRepository;
import com.licence.dataservice.persistance.repositories.PackageRepository;
import com.licence.dataservice.persistance.repositories.UserRepository;
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
    public PackageService(PackageRepository packageRepository, UserRepository userRepository, DeliveryRepository deliveryRepository){
        this.packageRepository = packageRepository;
        this.userRepository = userRepository;
        this.deliveryRepository = deliveryRepository;
    }

    public PackageModel insertPackage (PackageModel pack){
        PackageEntity packageEntity = new PackageEntity();
        //packageEntity.setPackageId(pack.getPackageId());
        packageEntity.setProgress(pack.getProgress());
        packageEntity.setDropOffLatitude(pack.getDropOffLatitude());
        packageEntity.setDropOffLongitude(pack.getDropOffLongitude());
        packageEntity.setDropOffRange(pack.getDropOffRange());
        packageEntity.setItemName(pack.getItemName());
        // the problem is here
        //DeliveryEntity deliveryEntity = deliveryRepository.getById(pack.getDeliveryId());
        packageEntity.setDelivery(deliveryRepository.getById(pack.getDeliveryId()));
        packageEntity.setUser(userRepository.getById(pack.getUserId()));
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
