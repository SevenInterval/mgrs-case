package com.migros.validation;

import com.migros.dto.CourierDto;
import com.migros.dto.Geolocation;
import com.migros.utility.CommonException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourierValidatorTest {

    @Autowired
    private CourierValidator courierValidator;

    @Test
    public void checkCourierDtoTest() throws CommonException {
        CourierDto courierDto = new CourierDto();
        Geolocation geolocation = new Geolocation();
        geolocation.setLng(28.5651651);
        geolocation.setLat(45.1654789);
        courierDto.setGeolocation(geolocation);
        courierDto.setTime(LocalDateTime.now());
        courierDto.setCourier("Rıdvan");
        courierValidator.checkCourierDto(courierDto);
    }

}