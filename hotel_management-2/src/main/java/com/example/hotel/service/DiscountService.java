package com.example.hotel.service;

import com.example.hotel.model.Discount;
import com.example.hotel.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Discount getDiscountById(int discountId) {
        return discountRepository.findById(discountId).orElse(null);
    }

    public Discount saveDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    public void deleteDiscount(int discountId) {
        discountRepository.deleteById(discountId);
    }
}
