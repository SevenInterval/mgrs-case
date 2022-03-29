package com.migros.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COURIER_STORE")
@Data
public class CourierStore {

    @Id
    @SequenceGenerator(name = "seq_courier_store", allocationSize = 1)
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

    @OneToOne
    private Store store;
}
