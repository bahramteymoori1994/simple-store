package com.example.store.store.controllers;

import com.example.store.store.exceptions.ServiceException;
import com.example.store.store.model.entities.ReceivedPaper;
import com.example.store.store.services.ReceivedPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/received_paper")
public class ReceivedPaperController extends AbstractBaseController<ReceivedPaper>
{
    @Autowired
    private ReceivedPaperService receivedPaperService;

    @PostMapping("/searchDateAfter")
    public List<ReceivedPaper> findByPurchasedDateTimeAfter(LocalDateTime purchasedDateTime) throws ServiceException
    {
        return receivedPaperService.findByPurchasedDateTimeAfter(purchasedDateTime);
    }

    @PostMapping("/searchDateBefore")
    public List<ReceivedPaper> findByPurchasedDateTimeBefore(LocalDateTime purchasedDateTime) throws ServiceException
    {
        return receivedPaperService.findByPurchasedDateTimeBefore(purchasedDateTime);
    }
}