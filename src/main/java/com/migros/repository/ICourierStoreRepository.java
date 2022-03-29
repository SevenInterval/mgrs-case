package com.migros.repository;

import com.migros.model.CourierStore;
import com.migros.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ICourierStoreRepository extends JpaRepository<CourierStore, Long> {
    CourierStore findByStoreAndCourierAndTimeBetween(Store store, String courier, LocalDateTime fromTime, LocalDateTime toTime);

}
