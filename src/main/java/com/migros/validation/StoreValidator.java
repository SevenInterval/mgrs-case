package com.migros.validation;

import com.migros.dto.StoreDto;
import com.migros.utility.StoreException;
import org.springframework.stereotype.Component;

@Component
public class StoreValidator {
    public void checkStoreDto(StoreDto storeDto) throws StoreException {
        if(storeDto.getName() == null || storeDto.getName() == "") {
            throw new StoreException("Store name can not be null or empty!");
        }
        if(storeDto.getLat() == null) {
            throw new StoreException("Store lat can not be null");
        }
        if(storeDto.getLng() == null) {
            throw new StoreException("Store lng can not be null");
        }
    }
}
