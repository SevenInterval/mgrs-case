package com.migros.service;

import com.migros.model.Courier;
import com.migros.model.CourierStore;
import com.migros.model.Store;
import com.migros.repository.ICourierStoreRepository;
import com.migros.utility.CommonException;
import com.migros.validation.CourierStoreValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierStoreServiceImpl implements ICourierStoreService {

    Logger logger = LoggerFactory.getLogger( CourierStoreServiceImpl.class );

    private final ICourierStoreRepository courierStoreRepository;
    private final CourierStoreValidator courierStoreValidator;

    @Override
    public void saveCourierStore(Store store, Courier courier) throws CommonException {
        List<String> errorMessageList = courierStoreValidator.checkCourierTimeAndDistanceForTheStore(store, courier);
        if(errorMessageList.size() > 0) {
            errorMessageList.forEach(item -> {
                logger.error(item);
            });
        } else {
            CourierStore courierStore = new CourierStore();
            courierStore.setTime(courier.getTime());
            courierStore.setCourier(courier.getCourier());
            courierStore.setLat(courier.getLat());
            courierStore.setLng(courier.getLng());
            courierStore.setCreateTime(LocalDateTime.now());
            if(store != null) {
                courierStore.setStore(store);
            }
            courierStoreRepository.save(courierStore);
        }
    }
}
