package com.henripay.domainservice.entity.sepadd;

import com.henripay.domainservice.entity.type.StatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "transaction_request")
@Data
public class TransactionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_info_id", referencedColumnName = "id")
    private AccountInformationEntity accountInfo;

    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "currency")
    private String currency;

    @Temporal(TemporalType.DATE)
    @Column(name = "scheduled_execution_date")
    private Date scheduledExecutionDate;

    @Column(name = "end_to_end_transaction_reference")
    private String endToEndTransactionReference;

    @Column(name = "status")
    private StatusEnum status;

    @
    private String statusDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionRequest that = (TransactionRequest) o;
        return Objects.equals(this.accountInfo, that.accountInfo) &&
                Objects.equals(this.amount, that.amount) &&
                Objects.equals(this.currency, that.currency) &&
                Objects.equals(this.scheduledExecutionDate, that.scheduledExecutionDate) &&
                Objects.equals(this.endToEndTransactionReference, that.endToEndTransactionReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfo, amount, currency, scheduledExecutionDate, endToEndTransactionReference);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransactionRequest {\n");
        sb.append("    id: ").append(id).append("\n");
        sb.append("    accountInfo: ").append(accountInfo).append("\n");
        sb.append("    amount: ").append(amount).append("\n");
        sb.append("    currency: ").append(currency).append("\n");
        sb.append("    scheduledExecutionDate: ").append(scheduledExecutionDate).append("\n");
        sb.append("    endToEndTransactionReference: ").append(endToEndTransactionReference).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
