package com.migros.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COURIER")
@Data
public class Courier {
    @Id
    @SequenceGenerator(name = "seq_courier", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @Column(name = "courier", nullable = false)
    private String courier;

    @Column(name = "lat", nullable = false)
    private Double lat;

    @Column(name = "lng", nullable = false)
    private Double lng;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "distance", nullable = false)
    private Double distance;
}
