package com.example.store.store.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Audited
@EntityListeners(AuditingEntityListener.class)
@Table(name = "received_paper")
public class ReceivedPaper extends AbstractBaseEntity
{


    @Column(name = "PURCHASED_DATE_TIME")
    @CreatedDate
    private Date purchasedDateTime;

    @Column(name = "PRODUCT_COUNT")
    private Integer count;

    @OneToOne(mappedBy = "receivedPaper")
    private Customer customer;

    @OneToMany(mappedBy = "receivedPaper", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private List<Product> products;
}