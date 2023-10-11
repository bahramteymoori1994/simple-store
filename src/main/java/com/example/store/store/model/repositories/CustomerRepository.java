package com.example.store.store.model.repositories;

import com.example.store.store.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    List<Customer> findByName(String name);
    List<Customer> findByNameStartingWith(String prefix);
    List<Customer> findByNameEndingWith(String suffix);
    List<Customer> findByBalanceGreaterThanEqual(Long balance);
    List<Customer> findByBalanceBetween(Long firstBalance, Long lastBalance);
}