package com.example.store.store.controllers;

import com.example.store.store.exceptions.ServiceException;
import com.example.store.store.model.entities.Customer;
import com.example.store.store.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController extends AbstractBaseController<Customer>
{
    @Autowired
    private CustomerService customerService;


    @PostMapping("/searchByName")
    public List<Customer> findByName(String name) throws ServiceException
    {
        return customerService.findByName(name);
    }

    @PostMapping("/searchByStartingName")
    public List<Customer> findByNameStartingWith(String prefix) throws ServiceException
    {
        return customerService.findByNameStartingWith(prefix);
    }

    @PostMapping("/searchByEndingName")
    public List<Customer> findByNameEndingWith(String suffix) throws ServiceException
    {
        return customerService.findByNameEndingWith(suffix);
    }

    @PostMapping("/searchBalance")
    public List<Customer> findByBalanceGreaterThanEqual(Long balance) throws ServiceException
    {
        return customerService.findByBalanceGreaterThanEqual(balance);
    }

    @PostMapping("/searchBalanceBetween")
    public List<Customer> findByBalanceBetween(Long firstBalance, Long lastBalance) throws ServiceException
    {
        return customerService.findByBalanceBetween(firstBalance, lastBalance);
    }
}