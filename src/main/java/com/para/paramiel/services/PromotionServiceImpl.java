package com.para.paramiel.services;

import com.para.paramiel.entities.Promotion;
import com.para.paramiel.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public Optional<Promotion> findPromotionById(int id) {
        return promotionRepository.getPromotionById(id);
    }

    @Override
    public List<Promotion> findPromotionByStatus(boolean active) {
        return promotionRepository.getPromotionByStatus(String.valueOf(active));
    }

    @Override
    public List<Promotion> findAllPromotion() {
        return promotionRepository.findAll();
    }
}
