package com.henripay.domainservice.entity.sepadd;

import com.henripay.domainservice.entity.type.ProcessingStatusEnum;
import com.henripay.domainservice.entity.type.StatusEnum;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "credit_transfer_request")
public class CreditTransferRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_info_id", referencedColumnName = "id")
    private AccountInformationEntity accountInfo;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "scheduled_execution_date")
    private Date scheduledExecutionDate;

    @Column(name = "end_to_end_transaction_reference")
    private String endToEndTransactionReference;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "remittance_info")
    private String remittanceInfo;

    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "processing_status")
    private ProcessingStatusEnum processingStatus;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "creation_date")
    private Date creationDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "last_updated")
    private Date lastUpdated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditTransferRequestEntity that = (CreditTransferRequestEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "CreditTransferRequestEntity{" +
                "id=" + id +
                ", accountInfo=" + accountInfo +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", scheduledExecutionDate=" + scheduledExecutionDate +
                ", endToEndTransactionReference='" + endToEndTransactionReference + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", remittanceInfo='" + remittanceInfo + '\'' +
                '}';
    }
}
