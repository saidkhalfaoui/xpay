package com.henripay.domainservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class TransactionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "external_transaction_id", unique = true)
    private Integer externalTransactionId;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "customer_id_identifier")
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "received_id", referencedColumnName = "merchant_id")
    private MerchantEntity receiver;

    @Column(name = "execution_date", nullable = false)
    private LocalDate executionDate;
}
