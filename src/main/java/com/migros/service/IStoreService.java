package com.migros.service;

import com.migros.dto.StoreDto;
import com.migros.utility.StoreException;

import java.util.List;

public interface IStoreService {
    StoreDto saveStore(StoreDto store) throws StoreException;
    List<StoreDto> getAll();
}
