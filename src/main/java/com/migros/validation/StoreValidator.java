package com.migros.validation;

import com.migros.dto.StoreDto;
import com.migros.utility.CommonException;
import org.springframework.stereotype.Component;

@Component
public class StoreValidator {
    public void checkStoreDto(StoreDto storeDto) throws CommonException {
        if(storeDto.getName() == null || storeDto.getName() == "") {
            throw new CommonException("Store name can not be null or empty!");
        }
        if(storeDto.getLat() == null) {
            throw new CommonException("Store lat can not be null");
        }
        if(storeDto.getLng() == null) {
            throw new CommonException("Store lng can not be null");
        }
    }
}
