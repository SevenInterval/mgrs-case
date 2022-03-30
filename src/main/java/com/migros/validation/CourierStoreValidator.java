package com.migros.validation;

import com.migros.model.Courier;
import com.migros.model.CourierStore;
import com.migros.model.Store;
import com.migros.repository.ICourierStoreRepository;
import com.migros.utility.CommonException;
import com.migros.utility.CommonFunctions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CourierStoreValidator {

    private final ICourierStoreRepository courierStoreRepository;
    private final CommonFunctions commonFunctions;

    public List<String> checkCourierTimeAndDistanceForTheStore(Store store, Courier courier) throws CommonException {
        // Reentries to the same store's circumference over 1minute should not count as entrance.
        CourierStore courierStore = courierStoreRepository.findByStoreAndCourierAndTimeBetween(store, courier.getCourier(),
                courier.getTime().minusSeconds(Long.parseLong("60")),courier.getTime());
        List<String> storeErrorMessageList = new ArrayList<>();
        if(courierStore != null) {
           //throw new CommonException("The Courier entered the same Store within 1 minute! Store name is:" + store.getName());
            storeErrorMessageList.add("The Courier entered the same Store within 1 minute! Store name is:" + store.getName());
        }

        // Log courier and store when any courier enters radius of 100 meters from Migros stores.
        double distanceMeter = commonFunctions.findDistanceMeter(courier, store);
        if(distanceMeter > 100) {
           // throw new CommonException("The Courier is not within 100 meters of the store! Store name is:" + store.getName());
            storeErrorMessageList.add("The Courier is not within 100 meters of the store! Store name is:" + store.getName());
        }
        return storeErrorMessageList;
    }
}
