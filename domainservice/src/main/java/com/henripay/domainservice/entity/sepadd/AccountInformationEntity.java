package com.henripay.domainservice.entity.sepadd;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "account_information")
public class AccountInformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iban")
    private String iban;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @Column(name = "alternative_account_number")
    private String alternativeAccountNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_info_id", referencedColumnName = "id")
    private TaxInfoEntity taxInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountInformationEntity that = (AccountInformationEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(iban, that.iban) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(alternativeAccountNumber, that.alternativeAccountNumber) &&
                Objects.equals(taxInfo, that.taxInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iban, name, address, alternativeAccountNumber, taxInfo);
    }

    @Override
    public String toString() {
        return "AccountInformationEntity{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", alternativeAccountNumber='" + alternativeAccountNumber + '\'' +
                ", taxInfo=" + taxInfo +
                '}';
    }
}
