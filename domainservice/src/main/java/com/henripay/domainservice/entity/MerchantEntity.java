package com.henripay.domainservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchant")
public class MerchantEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchant_id")
    private Long merchantId;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "merchant_name")
    private String merchantName;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "merchant_address")
    private String merchantAddress;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "merchant_iban")
    private String merchantIban;

    @Column(name = "merchant_code", unique = true)
    private String merchantCode;

    @ManyToOne
    @JoinColumn(name = "merchant_meta", referencedColumnName = "metadata_id")
    private MetadataEntity metadata;

    @ManyToOne
    @JoinColumn(name = "id_merchant_aggregator", referencedColumnName = "aggregator_id")
    private AggregatorEntity aggregator;
}
