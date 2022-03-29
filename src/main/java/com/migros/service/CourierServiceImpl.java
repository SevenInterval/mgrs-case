package com.migros.service;

import com.migros.dto.CourierDto;
import com.migros.dto.StoreDto;
import com.migros.model.Courier;
import com.migros.model.Store;
import com.migros.repository.ICourierRepository;
import com.migros.utility.CommonException;
import com.migros.utility.CommonFunctions;
import com.migros.validation.CourierValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements ICourierService {

    private final ICourierRepository courierRepository;
    private final CourierValidator courierValidator;
    private final IStoreService storeService;
    private final CommonFunctions commonFunctions;
    private final ICourierStoreService courierStoreService;

    @Override
    public void saveCourier(CourierDto courierDto) throws CommonException {
        courierValidator.checkCourierDto(courierDto);
        Courier courier = new Courier();
        courier.setCourier(courierDto.getCourier());
        courier.setLat(courierDto.getGeolocation().getLat());
        courier.setLng(courierDto.getGeolocation().getLng());
        courier.setTime(courierDto.getTime());
        Courier lastCourier = courierRepository.getLastCourierData(courier.getCourier());
        double distanceMeter = 0;
        if(lastCourier != null) {
            distanceMeter = commonFunctions.findDistanceOfCourier(courierDto, lastCourier);
        }
        courier.setDistance(distanceMeter);
        courier.setCreateTime(LocalDateTime.now());
        courierRepository.save(courier);
        List<Store> storeList = storeService.getAll();
        for(Store store: storeList) {
            courierStoreService.saveCourierStore(store, courier);
        }
    }

    @Override
    public List<Courier> getAllCouriers() {
        List<Courier> courierList = courierRepository.findAll();
        return courierList;
    }

    @Override
    public Double getTotalTravelDistance(Long id) {
        Double totalTravelDistance = courierRepository.getSumDistanceOfCourier(id);
        return totalTravelDistance;
    }
}
