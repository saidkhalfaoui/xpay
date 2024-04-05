package com.henripay.domainservice.entity;

import com.henripay.domainservice.entity.type.Statusenum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class TransactionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "transaction_id")
    private String transactionId;

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

    @Column(name = "execution_date")
    private LocalDate executionDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "scheduled_execution_date")
    private LocalDate scheduledExecutionDate;

    @Column(name = "end_to_end_transaction_reference")
    private String endToEndTransactionReference;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Statusenum status;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "remittance_info")
    private String remittanceInfo;

    @Column(name = "processing_status")
    private String processingStatus;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "last_updated")
    private LocalDate lastUpdated;

    @Column(name = "authorisation_1_code")
    private String authorisation1Code;

    @Column(name = "internal_transaction_reference")
    private String internalTransactionReference;

    @Column(name = "meta_data")
    private String metaData;

    @Column(name = "nature")
    private String nature;

    public JsonNode getMetaData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(this.metaData);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing JSON data", e);
        }
    }

}
