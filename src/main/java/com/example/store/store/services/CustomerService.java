package com.example.store.store.services;

import com.example.store.store.exceptions.ServiceException;
import com.example.store.store.model.entities.Customer;
import com.example.store.store.model.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService extends AbstractBaseService<CustomerRepository, Customer>
{
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findByName(String name) throws ServiceException
    {
        return customerRepository.findByName(name);
    }

    public List<Customer> findByNameStartingWith(String prefix) throws ServiceException
    {
        return customerRepository.findByNameStartingWith(prefix);
    }

    public List<Customer> findByNameEndingWith(String suffix) throws ServiceException
    {
        return customerRepository.findByNameEndingWith(suffix);
    }
    public List<Customer> findByBalanceGreaterThanEqual(Long balance) throws ServiceException
    {
        return customerRepository.findByBalanceGreaterThanEqual(balance);
    }
    public List<Customer> findByBalanceBetween(Long firstBalance, Long lastBalance) throws ServiceException
    {
        return customerRepository.findByBalanceBetween(firstBalance, lastBalance);
    }
}