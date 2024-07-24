package com.WS.Dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.WS.Entity.Supplier;

public interface SupplierDAO extends JpaRepository<Supplier, Integer> {
    @Query("SELECT s FROM Supplier s WHERE s.activated = true")
    List<Supplier> findAllActivatedSupplier();
    @Query("SELECT s FROM Supplier s WHERE s.activated = true")
    List<Supplier> findAllActivatedSupplierV2(Sort sort);

    @Query("SELECT s FROM Supplier s WHERE s.name LIKE %:keywords% OR s.address LIKE %:keywords% OR str(s.id) LIKE %:keywords%")
    List<Supplier> searchSupplierByName(@Param("keywords") String keywords);

}
