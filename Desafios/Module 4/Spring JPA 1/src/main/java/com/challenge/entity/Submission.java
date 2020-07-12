package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

/**
 * com.challenge.entity @Entity(name = "submission")
 * @Table submission
 * public class Submission
 * extends Object
 *
 * Columns:
 * id           - EmbeddedId @Class SubmissionId
 * score        - float
 * created_at   - timestamp
 */

@Entity
@Table (name = "submission")
@EntityListeners(AuditingEntityListener.class)

public class Submission {

    @EmbeddedId
    private SubmissionId id;

    @Column
    @NotNull
    private float score;

    @Column (name = "created_at")
    @CreatedDate
    private Timestamp createdAt;

    //Contructor
    public Submission (){

    }

    public Submission(SubmissionId id,
                      @NotNull float score,
                      Timestamp createdAt) {

        this.id = id;
        this.score = score;
        this.createdAt = createdAt;
    }

    //Getters and setters
    public SubmissionId getId() {
        return id;
    }

    public void setId(SubmissionId id) {
        this.id = id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}