package com.henripay.domainservice.entity.sepadd;

import com.henripay.domainservice.entity.type.ProcessingStatusEnum;
import com.henripay.domainservice.entity.type.StatusEnum;
import com.henripay.domainservice.entity.type.TransactionType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "direct_debit_request")
@Data
public class DirectDebitRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_info_id", referencedColumnName = "id")
    private AccountInformationEntity accountInfo;

    @Column(name = "amount")
    private BigDecimal amount;

    private String currency;

    @Temporal(TemporalType.DATE)
    @Column(name = "scheduled_execution_date")
    private Date scheduledExecutionDate;

    @Column(name = "end_to_end_transaction_reference")
    private String endToEndTransactionReference;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mandate_info_id", referencedColumnName = "id")
    private MandateInformationEntity mandateInformation;

    @Column(name = "authorisation_1_code")
    private String authorisation1Code;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @Column(name = "internal_transaction_reference")
    private String internalTransactionReference;

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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DirectDebitRequest that = (DirectDebitRequest) o;
        return Objects.equals(this.accountInfo, that.accountInfo) &&
                Objects.equals(this.amount, that.amount) &&
                Objects.equals(this.currency, that.currency) &&
                Objects.equals(this.scheduledExecutionDate, that.scheduledExecutionDate) &&
                Objects.equals(this.endToEndTransactionReference, that.endToEndTransactionReference) &&
                Objects.equals(this.mandateInformation, that.mandateInformation) &&
                Objects.equals(this.authorisation1Code, that.authorisation1Code) &&
                this.transactionType == that.transactionType &&
                Objects.equals(this.internalTransactionReference, that.internalTransactionReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfo, amount, currency, scheduledExecutionDate, endToEndTransactionReference, mandateInformation, authorisation1Code, transactionType, internalTransactionReference);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DirectDebitRequest {\n");
        sb.append("    id: ").append(id).append("\n");
        sb.append("    accountInfo: ").append(accountInfo).append("\n");
        sb.append("    amount: ").append(amount).append("\n");
        sb.append("    currency: ").append(currency).append("\n");
        sb.append("    scheduledExecutionDate: ").append(scheduledExecutionDate).append("\n");
        sb.append("    endToEndTransactionReference: ").append(endToEndTransactionReference).append("\n");
        sb.append("    mandateInformation: ").append(mandateInformation).append("\n");
        sb.append("    authorisation1Code: ").append(authorisation1Code).append("\n");
        sb.append("    transactionType: ").append(transactionType).append("\n");
        sb.append("    internalTransactionReference: ").append(internalTransactionReference).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
