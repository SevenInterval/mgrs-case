package com.migros.repository;

import com.migros.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICourierRepository extends JpaRepository<Courier, Long> {
    @Query("SELECT c FROM Courier c WHERE c.courier = :courier and c.id=(SELECT MAX(d.id) FROM Courier d WHERE d.courier = :courier)")
    Courier getLastCourierData(String courier);

    @Query("SELECT SUM(c.distance) FROM Courier c WHERE c.id=:id")
    Double getSumDistanceOfCourier(Long id);
}
