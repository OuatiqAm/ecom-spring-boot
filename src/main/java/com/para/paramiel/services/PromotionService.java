package com.para.paramiel.services;


import com.para.paramiel.entities.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionService {
    
    Optional<Promotion> findPromotionById(int id);

    List<Promotion> findPromotionByStatus(boolean active);

    List<Promotion> findAllPromotion();
    
}
