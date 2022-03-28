package com.migros.repository;

import com.migros.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStoreRepository extends JpaRepository<Store, Long> {
}
