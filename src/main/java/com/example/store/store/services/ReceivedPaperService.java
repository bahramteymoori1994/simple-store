package com.example.store.store.services;

import com.example.store.store.exceptions.ServiceException;
import com.example.store.store.model.entities.ReceivedPaper;
import com.example.store.store.model.repositories.ReceivedPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReceivedPaperService extends AbstractBaseService<ReceivedPaperRepository, ReceivedPaper>
{
    @Autowired
    private ReceivedPaperRepository receivedPaperRepository;

    public List<ReceivedPaper> findByPurchasedDateTimeAfter(LocalDateTime purchasedDateTime) throws ServiceException
    {
        return receivedPaperRepository.findByPurchasedDateTimeAfter(purchasedDateTime);
    }
    public List<ReceivedPaper> findByPurchasedDateTimeBefore(LocalDateTime purchasedDateTime) throws ServiceException
    {
        return receivedPaperRepository.findByPurchasedDateTimeBefore(purchasedDateTime);
    }
}