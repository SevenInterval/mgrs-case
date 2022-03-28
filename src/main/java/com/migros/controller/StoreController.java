package com.migros.controller;

import com.migros.dto.StoreDto;
import com.migros.service.IStoreService;
import com.migros.utility.StoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/store") //pre-path
public class StoreController {

    @Autowired
    private IStoreService storeService;

    @PostMapping // -> api/store
    public ResponseEntity<StoreDto> saveStore(@RequestBody StoreDto store) throws StoreException {
        return new ResponseEntity<>(storeService.saveStore(store), HttpStatus.CREATED);
    }
}
