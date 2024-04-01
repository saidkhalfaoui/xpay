package com.henripay.domainservice.entity.sepadd;

import com.henripay.domainservice.entity.type.StatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "job_status")
public class JobStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "start_date")
    private Date startDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobStatusEntity that = (JobStatusEntity) o;
        return Objects.equals(id, that.id) &&
                status == that.status &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, startDate);
    }

    @Override
    public String toString() {
        return "JobStatusEntity{" +
                "id=" + id +
                ", status=" + status +
                ", startDate=" + startDate +
                '}';
    }
}
