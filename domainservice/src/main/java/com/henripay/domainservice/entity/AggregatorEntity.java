package com.henripay.domainservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;

@Setter
@Getter
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
