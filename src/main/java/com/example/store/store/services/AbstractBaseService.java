package com.example.store.store.services;

import com.example.store.store.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public abstract class AbstractBaseService<R extends JpaRepository<E, Long>, E>
{
    @Autowired
    private R repository;

    public void add(E entity) throws ServiceException
    {
        this.repository.save(entity);
    }

    public void update(E entity) throws ServiceException
    {
        this.repository.save(entity);
    }

    public void deleteById(Long id) throws ServiceException
    {
        this.repository.deleteById(id);
    }

    public Optional<E> findById(Long id) throws ServiceException
    {
        return this.repository.findById(id);
    }

    public List<E> findAll() throws ServiceException
    {
        return this.repository.findAll();
    }
}