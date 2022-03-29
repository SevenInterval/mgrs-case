package com.migros.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourierDto {
    private LocalDateTime time;
    private String courier;
    private Geolocation geolocation;
}
