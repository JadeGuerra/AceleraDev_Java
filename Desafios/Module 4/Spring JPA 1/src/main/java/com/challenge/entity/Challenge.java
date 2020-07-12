package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

/**
 * com.challenge.entity @Entity(name = "challenge")
 * @Table challenge
 * public class Challenge
 * extends Object
 *
 * Columns:
 * id         - int @OneToMany
 * name       - varchar (100)
 * slug       - varchar(50)
 * created_at - timestamp
 *
 * Bilateral relation with
 * @Table acceleration - @OneToMany
 * @Table submission   - @OneToMany
 */

@Entity
@Table (name = "challenge")
@EntityListeners(AuditingEntityListener.class)
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    @Size(max = 100)
    private String name;

    @Column
    @NotNull
    @Size(max= 50)
    private String slug;

    @Column (name = "created_at")
    @CreatedDate
    private Timestamp createdAt;

    @OneToMany
    private List<Submission> submissions;

    @OneToMany
    private List<Acceleration> accelerations;

    //Constructor

    public Challenge (){

    }

    public Challenge(@NotNull int id,
                     @NotNull @Size(max = 100) String name,
                     @NotNull @Size(max = 50) String slug,
                     Timestamp createdAt,
                     List<Submission> submissions,
                     List<Acceleration> accelerations) {

        this.id = id;
        this.name = name;
        this.slug = slug;
        this.createdAt = createdAt;
        this.submissions = submissions;
        this.accelerations = accelerations;
    }

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public List<Acceleration> getAccelerations() {
        return accelerations;
    }

    public void setAccelerations(List<Acceleration> accelerations) {
        this.accelerations = accelerations;
    }
}

