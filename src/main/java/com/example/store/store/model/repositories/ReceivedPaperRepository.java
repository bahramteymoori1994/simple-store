package com.example.store.store.model.repositories;

import com.example.store.store.model.entities.ReceivedPaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReceivedPaperRepository extends JpaRepository<ReceivedPaper, Long>
{
    List<ReceivedPaper> findByPurchasedDateTimeAfter(LocalDateTime purchasedDateTime);
    List<ReceivedPaper> findByPurchasedDateTimeBefore(LocalDateTime purchasedDateTime);
}