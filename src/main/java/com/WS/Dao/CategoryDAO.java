package com.WS.Dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.WS.Entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
    List<Category> findByActivatedTrue(Sort sort);

    @Query("SELECT c FROM Category c WHERE c.activated = true")
    List<Category> findAllActivatedCategory();
    @Query("SELECT c FROM Category c WHERE c.activated = true")
    List<Category> findAllActivatedCategoryV2(Sort sort);
//    @Query("SELECT c FROM Category c WHERE c.name LIKE %:keywords% OR c.id LIKE %:keywords%")
//    List<Category> searchCategoryByName(@Param("keywords") String keywords);
        @Query("SELECT c FROM Category c WHERE c.name LIKE %:keywords% OR str(c.id) LIKE %:keywords%")
        List<Category> searchCategoryByName(@Param("keywords") String keywords);

}
