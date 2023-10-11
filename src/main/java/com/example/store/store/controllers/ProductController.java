package com.example.store.store.controllers;

import com.example.store.store.exceptions.ServiceException;
import com.example.store.store.model.entities.Product;
import com.example.store.store.model.enums.Brand;
import com.example.store.store.model.enums.Item;
import com.example.store.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractBaseController<Product>
{
    @Autowired
    private ProductService productService;

    @PostMapping("/searchItem")
    public List<Product> findByItem(Item item) throws ServiceException
    {
        return productService.findByItem(item);
    }

    @PostMapping("/searchItemStarting")
    public List<Product> findByItemStartingWith(Item item) throws ServiceException
    {
        return productService.findByItemStartingWith(item);
    }

    @PostMapping("/searchItemEnding")
    public List<Product> findByItemEndingWith(Item item) throws ServiceException
    {
        return productService.findByItemEndingWith(item);
    }

    @PostMapping("/searchBrand")
    public List<Product> findByBrand(Brand brand) throws ServiceException
    {
        return productService.findByBrand(brand);
    }

    @PostMapping("/searchBuyPrice")
    public List<Product> findByBuyPriceGreaterThanEqual(Long buyPrice) throws ServiceException
    {
        return productService.findByBuyPriceGreaterThanEqual(buyPrice);
    }

    @PostMapping("/searchBuyPriceBetween")
    public List<Product> findByBuyPriceBetween(Long buyPriceFirst, Long buyPriceSecond) throws ServiceException
    {
        return productService.findByBuyPriceBetween(buyPriceFirst, buyPriceSecond);
    }
}