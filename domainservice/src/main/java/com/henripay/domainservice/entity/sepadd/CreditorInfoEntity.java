package com.henripay.domainservice.entity.sepadd;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "creditor_info")
public class CreditorInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_info_id", referencedColumnName = "id")
    private AccountInformationEntity accountInfo;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditorInfoEntity that = (CreditorInfoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(accountInfo, that.accountInfo) &&
                Objects.equals(isDefault, that.isDefault);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountInfo, isDefault);
    }

    @Override
    public String toString() {
        return "CreditorInfoEntity{" +
                "id=" + id +
                ", accountInfo=" + accountInfo +
                ", isDefault=" + isDefault +
                '}';
    }
}
