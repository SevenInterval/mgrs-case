package com.migros.service;

import com.migros.dto.StoreDto;
import com.migros.model.Store;
import com.migros.repository.IStoreRepository;
import com.migros.utility.CommonException;
import com.migros.validation.StoreValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements IStoreService {

    private final IStoreRepository storeRepository;
    private final StoreValidator storeValidator;

    @Override
    public StoreDto saveStore(StoreDto storeDto) throws CommonException {
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

    @Override
    public List<Store> getAll() {
        List<Store> storeList = storeRepository.findAll();
        return storeList;
    }
}
