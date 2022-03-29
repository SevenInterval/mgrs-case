package com.migros.service;

import com.migros.dto.StoreDto;
import com.migros.model.Store;
import com.migros.utility.CommonException;

import java.util.List;

public interface IStoreService {
    StoreDto saveStore(StoreDto store) throws CommonException;
    List<Store> getAll();
}
