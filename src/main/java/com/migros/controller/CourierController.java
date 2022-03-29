package com.migros.controller;

import com.migros.dto.CourierDto;
import com.migros.service.ICourierService;
import com.migros.utility.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/courier") //pre-path
public class CourierController {

    @Autowired
    private ICourierService courierService;

    @PostMapping // -> api/courier
    public ResponseEntity<CourierDto> saveCourier(@RequestBody CourierDto courierDto) throws CommonException {
        courierService.saveCourier(courierDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping // -> api/courier
    public ResponseEntity<?> getAllCouriers() {
        return ResponseEntity.ok(courierService.getAllCouriers());
    }

    @GetMapping("/distance/{courier}") // -> api/courier/distance/courier
    public ResponseEntity<?> getTotalTravelDistance(@PathVariable String courier) {
        return ResponseEntity.ok(courierService.getTotalTravelDistance(courier));
    }

}
