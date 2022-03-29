package com.migros.service;

import com.migros.model.Courier;
import com.migros.model.Store;
import com.migros.utility.CommonException;

public interface ICourierStoreService {
    void saveCourierStore(Store store, Courier courier) throws CommonException;
}
