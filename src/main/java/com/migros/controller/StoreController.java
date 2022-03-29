package com.migros.controller;

import com.migros.dto.StoreDto;
import com.migros.model.Store;
import com.migros.service.IStoreService;
import com.migros.utility.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/store") //pre-path
public class StoreController {

    @Autowired
    private IStoreService storeService;

    @PostMapping // -> api/store
    public ResponseEntity<StoreDto> saveStore(@RequestBody StoreDto store) throws CommonException {
        return new ResponseEntity<>(storeService.saveStore(store), HttpStatus.CREATED);
    }

    @GetMapping // -> api/store
    public ResponseEntity<List<Store>> getAllStores() {
        return ResponseEntity.ok(storeService.getAll());
    }
}
