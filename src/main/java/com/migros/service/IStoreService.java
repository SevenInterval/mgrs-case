package com.migros.service;

import com.migros.dto.StoreDto;
import com.migros.utility.StoreException;

public interface IStoreService {
    StoreDto saveStore(StoreDto store) throws StoreException;
}
