package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class BuyNow {
    @Autowired
    ProductRepository products = new ProductRepository() {
        @Override
        public List<Product> search(String keyword) {
            return List.of();
        }

        @Override
        public <S extends Product> S save(S entity) {
            return null;
        }

        @Override
        public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public Optional<Product> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public Iterable<Product> findAll() {
            return null;
        }

        @Override
        public Iterable<Product> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Product entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Product> entities) {

        }

        @Override
        public void deleteAll() {

        }
    };
    @GetMapping("/buyNow")
    public String buyNow(@Valid @RequestParam("productID") Long productID){
        Optional<Product> product = products.findById(productID);
        if (product.isPresent()){
            int numProducts = product.get().getInv();
            if(numProducts > 0){
                product.get().setInv(numProducts - 1);
                Product newCount = product.get();
                products.save(newCount);
                return "buySuccess";
            }
            else{
                return "buyFail";
            }
        }
        else {
            return "buyFail";
        }
    }
}