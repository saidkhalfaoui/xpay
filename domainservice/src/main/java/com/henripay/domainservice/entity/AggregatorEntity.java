package com.henripay.domainservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "aggregator")
public class AggregatorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aggregator_id")
    private Long aggregatorId;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "aggregator_name")
    private String aggregatorName;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "aggregator_address")
    private String aggregatorAddress;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "aggregator_iban")
    private String aggregatorIban;

    @ManyToOne
    @JoinColumn(name = "aggregator_meta_data", referencedColumnName = "metadata_id")
    private MetadataEntity metadata;
}
