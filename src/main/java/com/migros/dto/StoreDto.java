package com.migros.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoreDto {
    private Long id;
    private String name;
    private Double lat;
    private Double lng;
    private LocalDateTime createTime;
}
