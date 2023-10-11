package com.example.store.store.services;

import com.example.store.store.exceptions.ServiceException;
import com.example.store.store.model.entities.Product;
import com.example.store.store.model.enums.Brand;
import com.example.store.store.model.enums.Item;
import com.example.store.store.model.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends AbstractBaseService<ProductRepository, Product>
{
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByItem(Item item) throws ServiceException
    {
        return productRepository.findByItem(item);
    }
    public List<Product> findByItemStartingWith(Item item) throws ServiceException
    {
        return productRepository.findByItemStartingWith(item);
    }
    public List<Product> findByItemEndingWith(Item item) throws ServiceException
    {
        return productRepository.findByItemEndingWith(item);
    }
    public List<Product> findByBrand(Brand brand) throws ServiceException
    {
        return productRepository.findByBrand(brand);
    }
    public List<Product> findByBuyPriceGreaterThanEqual(Long buyPrice) throws ServiceException
    {
        return productRepository.findByBuyPriceGreaterThanEqual(buyPrice);
    }
    public List<Product> findByBuyPriceBetween(Long buyPriceFirst, Long buyPriceSecond) throws ServiceException
    {
        return productRepository.findByBuyPriceBetween(buyPriceFirst, buyPriceSecond);
    }
}