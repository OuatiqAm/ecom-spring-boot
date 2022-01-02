package com.para.paramiel.repositories;

import com.para.paramiel.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion,Integer> {
    @Query("Select p from Promotion as p where p.id = :id")
    Optional<Promotion> getPromotionById(int id);

    @Query("Select p from Promotion as p where  p.active= :active")
    List<Promotion> getPromotionByStatus(@Param(value ="active")String active);



}
