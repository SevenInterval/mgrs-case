package com.migros.utility;

import com.migros.dto.CourierDto;
import com.migros.dto.Geolocation;
import com.migros.model.Courier;
import com.migros.model.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommonFunctionsTest {

    @Autowired
    private CommonFunctions commonFunctions;

    @Test
    public void findDistanceMeterTest() {
        Courier courier = new Courier();
        courier.setLng(28.5651651);
        courier.setLat(45.1654789);
        Store store = new Store();
        store.setLat(45.1654789);
        store.setLng(28.5651651);
        assertEquals(commonFunctions.findDistanceMeter(courier, store), 0);
    }

    @Test
    public void findDistanceOfCourierTest() {
        CourierDto courierDto = new CourierDto();
        Geolocation geolocation = new Geolocation();
        geolocation.setLng(28.5651651);
        geolocation.setLat(45.1654789);
        courierDto.setGeolocation(geolocation);
        Courier courier = new Courier();
        courier.setLng(28.5651651);
        courier.setLat(45.1654789);
        assertEquals(commonFunctions.findDistanceOfCourier(courierDto, courier), 0);
    }

}