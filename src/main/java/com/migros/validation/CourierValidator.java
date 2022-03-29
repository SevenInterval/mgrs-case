package com.migros.validation;

import com.migros.dto.CourierDto;
import com.migros.utility.CommonException;
import org.springframework.stereotype.Component;

@Component
public class CourierValidator {

    public void checkCourierDto(CourierDto courierDto) throws CommonException {
        if(courierDto.getTime() == null) {
            throw new CommonException("Courier time can not be null or empty!");
        }
        if(courierDto.getGeolocation() != null) {
            if(courierDto.getGeolocation().getLat() == null) {
                throw new CommonException("Courier geolocation lat can not be null");
            }
            if(courierDto.getGeolocation().getLng() == null) {
                throw new CommonException("Courier geolocation lng can not be null");
            }
        } else {
            throw new CommonException("Courier geolocation can not be null or empty!");
        }

        if(courierDto.getCourier() == null) {
            throw new CommonException("Courier name can not be null");
        }

    }
}
