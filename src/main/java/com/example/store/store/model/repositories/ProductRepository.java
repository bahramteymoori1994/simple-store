package com.example.store.store.model.repositories;

import com.example.store.store.model.entities.Customer;
import com.example.store.store.model.entities.Product;
import com.example.store.store.model.enums.Brand;
import com.example.store.store.model.enums.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    List<Product> findByItem(Item item);
    List<Product> findByItemStartingWith(Item item);
    List<Product> findByItemEndingWith(Item item);
    List<Product> findByBrand(Brand brand);
    List<Product> findByBuyPriceGreaterThanEqual(Long buyPrice);
    List<Product> findByBuyPriceBetween(Long buyPriceFirst, Long buyPriceSecond);
}