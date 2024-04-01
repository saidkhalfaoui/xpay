package com.henripay.domainservice.entity.sepadd;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "tax_info")
public class TaxInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bsn")
    private String bsn;

    @Column(name = "kvk")
    private String kvk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxInfoEntity that = (TaxInfoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bsn, that.bsn) &&
                Objects.equals(kvk, that.kvk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bsn, kvk);
    }

    @Override
    public String toString() {
        return "TaxInfoEntity{" +
                "id=" + id +
                ", bsn='" + bsn + '\'' +
                ", kvk='" + kvk + '\'' +
                '}';
    }
}
