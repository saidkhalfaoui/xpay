package com.henripay.domainservice.entity;

import com.henripay.domainservice.entity.type.KeySourceEnum;
import com.henripay.domainservice.entity.type.KeyTypeEnum;
import com.henripay.domainservice.entity.type.KeyUsageEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "key_profile")
public class KeyProfileEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_profile_id")
    private Long keyProfileId;

    @Column(name = "key_profile_name")
    private String keyProfileName;

    @Column(name = "key_length")
    private Integer keyLength;

    @Enumerated(EnumType.STRING)
    @Column(name = "key_type")
    private KeyTypeEnum keyType;

    @ElementCollection
    @CollectionTable(name = "key_usage", joinColumns = @JoinColumn(name = "key_profile_id"))
    @Column(name = "key_usage")
    @Enumerated(EnumType.STRING)
    private List<KeyUsageEnum> keyUsages;


    @Enumerated(EnumType.STRING)
    @Column(name = "key_source")
    private KeySourceEnum keySource;

    @ManyToOne
    @JoinColumn(name = "storage_Key_profile", referencedColumnName = "key_profile_id", insertable = false, updatable = false)
    private KeyProfileEntity storageKeyProfile;

}
