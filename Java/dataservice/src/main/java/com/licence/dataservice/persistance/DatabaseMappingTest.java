package com.licence.dataservice.persistance;

import com.licence.dataservice.model.Warehouse;
import com.licence.dataservice.persistance.entities.*;
import com.licence.dataservice.persistance.repositories.*;
import org.springframework.stereotype.Service;

@Service
public class DatabaseMappingTest {
    private UserRepository userRepository;
    private DriverRepository driverRepository;
    private LogInRepository logInRepository;
    private PackageRepository packageRepository;
    private WarehouseRepository warehouseRepository;
    private DeliveryRepository deliveryRepository;


    public DatabaseMappingTest(UserRepository userRepository, DriverRepository driverRepository, LogInRepository logInRepository,
                               PackageRepository packageRepository, WarehouseRepository warehouseRepository, DeliveryRepository deliveryRepository) {
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
        this.logInRepository = logInRepository;
        this.packageRepository = packageRepository;
        this.warehouseRepository = warehouseRepository;
        this.deliveryRepository = deliveryRepository;
    }

    public void persistEntities(){
        LogInEntity logIn3 = new LogInEntity(3,"testUser2","testUser2","User","testUser2", "testUser2");
        LogInEntity logIn4 = new LogInEntity(4,"testDriver2","testDriver2","Driver","testDriver2", "testDriver2");

        WarehouseEntity warehouse2 = new WarehouseEntity();
        warehouse2.setWarehouseId(2);
        warehouse2.setLatitude(0);
        warehouse2.setLongitude(0);
        warehouse2.setPickUpRange(40);
        warehouse2.setWarehouseAdress("test");
        warehouse2.setWarehouseName("test");

        UserEntity user2 = new UserEntity();
        user2.setUserId(2);
        user2.setUserFirstName("User");
        user2.setUserLastName("McUserton");
        user2.setUserAdress("UserVille");
        user2.setLatitude(0);
        user2.setLongitude(0);
        user2.setDeliveryRange(10);
        user2.setLogIn(logIn3);

        DriverEntity driver2 = new DriverEntity();
        driver2.setDriverId(2);
        driver2.setDriverFirstName("Driver");
        driver2.setDriverLastName("McDriverson");
        driver2.setLogIn(logIn4);

        DeliveryEntity delivery2 = new DeliveryEntity();
        delivery2.setDeliveryId(2);
        delivery2.setLatitude(0);
        delivery2.setLongitude(0);
        delivery2.setProgress("Delivering");
        int nr = 0;
        delivery2.setNumberOfPackages(0);
        delivery2.setDriver(driver2);
        delivery2.setWarehouse(warehouse2);

        PackageEntity package2 = new PackageEntity();
        package2.setPackageId(2);
        package2.setItemName("TestItem");
        package2.setDropOffLatitude(0);
        package2.setDropOffLongitude(0);
        package2.setProgress("Moving");
        package2.setUser(user2);
        package2.setDropOffRange(package2.getUser().getDeliveryRange());
        package2.setDelivery(delivery2);
        package2.getDelivery().setNumberOfPackages(nr++);

        warehouse2 = warehouseRepository.save(warehouse2);
        user2 = userRepository.save(user2);
        driver2 = driverRepository.save(driver2);
        delivery2 = deliveryRepository.save(delivery2);
        package2 = packageRepository.save(package2);
    }



}
