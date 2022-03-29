package com.migros.service;

import com.migros.dto.CourierDto;
import com.migros.model.Courier;
import com.migros.utility.CommonException;

import java.util.List;

public interface ICourierService {
    void saveCourier(CourierDto courierDto) throws CommonException;
    List<Courier> getAllCouriers();
    Double getTotalTravelDistance(Long courierId);
}
