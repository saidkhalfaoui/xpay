package com.henripay.domainservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mandate")
public class MandateEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mandate_identifier")
    private Long mandateIdentifier;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id_identifier")
    private UserEntity customer;

    @ManyToOne
    @JoinColumn(name = "merchant_id", referencedColumnName = "merchant_id")
    private MerchantEntity merchant;

    @Column(name = "signature_date", nullable = false)
    private LocalDate signatureDate;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}