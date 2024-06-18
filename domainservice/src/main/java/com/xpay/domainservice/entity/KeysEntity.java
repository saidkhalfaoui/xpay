package com.xpay.domainservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "keys")
public class KeysEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_id")
    private Long keyId;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "key_name")
    private String keyName;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "key_type")
    private String keyType;

    @Column(name = "additional_info")
    private String additionalInfo;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "enc_key_value")
    private String encKeyValue;

    @ManyToOne
    @JoinColumn(name = "second_key_identifier", referencedColumnName = "key_id", insertable = false, updatable = false)
    private KeysEntity secondKey;
}
