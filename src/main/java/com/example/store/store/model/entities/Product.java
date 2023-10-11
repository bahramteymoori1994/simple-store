package com.example.store.store.model.entities;

import com.example.store.store.model.enums.Brand;
import com.example.store.store.model.enums.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Audited
@EntityListeners(AuditingEntityListener.class)
@Table(name = "product")
public class Product extends AbstractBaseEntity
{
    @Column(name = "PRODUCT_ITEM")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Your item field must not be null")
    private Item item;

    @Column(name = "PRODUCT_BRAND")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Your brand field must not be null")
    private Brand brand;

    @Column(name = "PRODUCT_BUY_PRICE")
    @NotNull(message = "Your buy price field must not be null")
    private Long buyPrice;

    @Column(name = "PRODUCT_NUMBER", length = 10, unique = true)
    @Pattern(regexp = "^\\d{10}$", message = "Your product number must be 10 digits")
    @NotNull(message = "Your product number must not be null")
    private String productNumber;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonIgnore
    private Customer customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "RECEIVED_PAPER_ID")
    @JsonIgnore
    private ReceivedPaper receivedPaper;
}