package com.henripay.domainservice.entity.sepadd;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "mandate_information")
@Data
public class MandateInformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mandate_id")
    private String mandateId;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_signature")
    private Date dateOfSignature;

    @Column(name = "person_id")
    private String personId;

    @Column(name = "is_amended")
    private Boolean isAmended;

    @Column(name = "electronic_signature")
    private String electronicSignature;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MandateInformationEntity that = (MandateInformationEntity) o;
        return Objects.equals(this.mandateId, that.mandateId) &&
                Objects.equals(this.dateOfSignature, that.dateOfSignature) &&
                Objects.equals(this.personId, that.personId) &&
                Objects.equals(this.isAmended, that.isAmended) &&
                Objects.equals(this.electronicSignature, that.electronicSignature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mandateId, dateOfSignature, personId, isAmended, electronicSignature);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MandateInformationEntity {\n");
        sb.append("    id: ").append(id).append("\n");
        sb.append("    mandateId: ").append(mandateId).append("\n");
        sb.append("    dateOfSignature: ").append(dateOfSignature).append("\n");
        sb.append("    personId: ").append(personId).append("\n");
        sb.append("    isAmended: ").append(isAmended).append("\n");
        sb.append("    electronicSignature: ").append(electronicSignature).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
