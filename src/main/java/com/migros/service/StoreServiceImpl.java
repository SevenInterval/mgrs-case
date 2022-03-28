package com.migros.service;

import com.migros.dto.StoreDto;
import com.migros.model.Store;
import com.migros.repository.IStoreRepository;
import com.migros.utility.StoreException;
import com.migros.validation.StoreValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements IStoreService {

    private final IStoreRepository storeRepository;
    private final StoreValidator storeValidator;

    @Override
    public StoreDto saveStore(StoreDto storeDto) throws StoreException {
        storeValidator.checkStoreDto(storeDto);
        Store store = new Store();
        store.setName(storeDto.getName());
        store.setLat(storeDto.getLat());
        store.setLng(storeDto.getLng());
        store.setCreateTime(LocalDateTime.now());
        final Store storeDb = storeRepository.save(store);
        storeDto.setId(storeDb.getId());
        storeDto.setCreateTime(storeDb.getCreateTime());
        return storeDto;
    }
}
