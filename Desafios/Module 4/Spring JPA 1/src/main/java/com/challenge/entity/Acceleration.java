package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


/**
 * com.challenge.entity @Entity(name = "acceleration")
 * @Table acceleration
 * public class Acceleration
 * extends Object
 *
 * Columns:
 * id           - int @OneToMany
 * name         - varchar (100)
 * slug         - varchar (50)
 * challenge_id - int @Table challenge, @column id, @ManytoOne
 * created_at   - timestamp
 *
 * Bilateral relation with
 * @Table challenge - @ManyToOne
 * @Table candidate - @OneToMany
 */

@Entity
@Table (name = "acceleration")
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    @Size(max = 100)
    private String name;

    @Column
    @NotNull
    @Size(max = 50)
    private String slug;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "challenge_id")
    @NotNull
    private Challenge challenge;

    @Column (name = "created_at")
    @CreatedDate
    private Timestamp createdAt;

    @OneToMany
    private List<Candidate> candidate;

    //Constructor
    public Acceleration() {


    }

    public Acceleration(int id,
                        @NotNull @Size(max = 100) String name,
                        @NotNull @Size(max = 50) String slug,
                        @NotNull Challenge challenge,
                        Timestamp createdAt,
                        List<Candidate> candidate) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.challenge = challenge;
        this.createdAt = createdAt;
        this.candidate = candidate;
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

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<Candidate> getCandidate() {
        return candidate;
    }

    public void setCandidate(List<Candidate> candidate) {
        this.candidate = candidate;
    }

}

