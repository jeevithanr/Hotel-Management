package com.example.hotel.controller;

import com.example.hotel.model.Discount;
import com.example.hotel.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/all")
    public ResponseEntity<List<Discount>> getAllDiscounts() {
        List<Discount> discounts = discountService.getAllDiscounts();
        return new ResponseEntity<>(discounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discount> getDiscountById(@PathVariable("id") int id) {
        Discount discount = discountService.getDiscountById(id);
        if (discount != null) {
            return new ResponseEntity<>(discount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount) {
        Discount createdDiscount = discountService.saveDiscount(discount);
        return new ResponseEntity<>(createdDiscount, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Discount> updateDiscount(@PathVariable("id") int id, @RequestBody Discount discount) {
        Discount existingDiscount = discountService.getDiscountById(id);
        if (existingDiscount != null) {
            existingDiscount.setDescription(discount.getDescription());
            existingDiscount.setPercentage(discount.getPercentage());
            discountService.saveDiscount(existingDiscount);
            return new ResponseEntity<>(existingDiscount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDiscount(@PathVariable("id") int id) {
        discountService.deleteDiscount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
