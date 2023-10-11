package com.example.store.store.controllers;

import com.example.store.store.exceptions.IdNotFoundException;
import com.example.store.store.exceptions.ServiceException;
import com.example.store.store.services.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractBaseController<E>
{
    @Autowired
    private AbstractBaseService<? extends JpaRepository<E, Long>, E> service;

    @PostMapping()
    public void add(@Validated @RequestBody E entity) throws ServiceException
    {
        this.service.add(entity);
    }

    @PutMapping()
    public void update(@Validated @RequestBody E entity) throws ServiceException
    {
        this.service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) throws ServiceException
    {
        if( id != null )
        {
            this.service.deleteById(id);
        }
        throw new IdNotFoundException("Id Not Found");
    }

    @GetMapping("/{id}")
    public E findById(@PathVariable("id") Long id) throws ServiceException
    {
        return this.service.findById(id).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
    }

    @GetMapping()
    public List<E> findAll() throws ServiceException
    {
        return this.service.findAll();
    }
}