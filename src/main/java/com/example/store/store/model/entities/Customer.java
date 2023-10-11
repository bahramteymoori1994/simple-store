package com.example.store.store.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Audited
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer")
public class Customer extends AbstractBaseEntity
{
    @Column(name = "FIRST_NAME", length = 20)
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$", message = "Invalid first name")
    @NotNull(message = "First name must not be null!")
    private String name;

    @Column(name = "LAST_NAME", length = 20)
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$", message = "Invalid last name")
    @NotNull(message = "Last name must not be null!")
    private String family;

    @Column(name = "EMAIL", length = 50, unique = true)
    @Email(message = "Enter an invalid email")
    @NotNull(message = "You email field mus not be null")
    private String email;

    @Column(name = "BALANCE")
    private Long balance;

    @Column(name = "PHONE_NUMBER")
    @Pattern(regexp = "^\\d{11}$")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "RECEIVED_PAPER_ID")
    private ReceivedPaper receivedPaper;
}