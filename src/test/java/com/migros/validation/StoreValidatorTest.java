package com.migros.validation;

import com.migros.dto.StoreDto;
import com.migros.utility.CommonException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreValidatorTest {

    @Autowired
    private StoreValidator storeValidator;

    @Test
    public void checkStoreDtoTestSuccess() throws CommonException {
        StoreDto storeDto = new StoreDto();
        storeDto.setName("MMM Capacity");
        storeDto.setLat(45.1654789);
        storeDto.setLng(28.5651651);
        storeValidator.checkStoreDto(storeDto);
    }

}