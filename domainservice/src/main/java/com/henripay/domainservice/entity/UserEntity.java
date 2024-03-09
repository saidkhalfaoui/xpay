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
import java.time.LocalDateTime;

@Data
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id_identifier")
    private Long customerIdIdentifier;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "iban")
    private String iban;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "token", unique = true)
    private String token;

    @Column(name = "address")
    private String address;

    @Column(name = "activation_date")
    private LocalDateTime activationDate;
}
