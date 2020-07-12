package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;


/**
 * com.challenge.entity @Entity(name = "candidate")
 * @Table candidate
 * public class Candidate
 * extends Object
 *
 * Columns:
 * id              - EmbeddedId @Class CandidateID
 * status          - int
 * created_at      - timestamp
 */


@Entity
@Table(name = "candidate")
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

    @EmbeddedId
    private CandidateId id;

    @Column
    @NotNull
    private int status;

    @Column(name = "created_at")
    @CreatedDate
    private Timestamp createdAt;

    //Constructor
    public Candidate() {

    }

    public Candidate(CandidateId id,
                     @NotNull int status,
                     Timestamp createdAt) {

        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
    }

    //Getters and setters

    public CandidateId getId() {
        return id;
    }

    public void setId(CandidateId id) {
        this.id = id;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}

