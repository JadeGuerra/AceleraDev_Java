package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

/**
 * com.challenge.entity @Entity(name = "company")
 * @Table company
 * public class Company
 * extends Object
 *
 * Columns:
 * id         - int @OneToMany
 * name       - varchar (100)
 * slug       - varchar (50)
 * created_at - timestamp
 *
 * Bilateral relation with
 * @Table candidate - @OneToMany
 */

@Entity
@Table (name = "company")
@EntityListeners(AuditingEntityListener.class)
public class Company {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    @Size (max = 100)
    private String name;

    @Column
    @NotNull
    @Size(max =50)
    private String slug;

    @Column (name = "created_at")
    @CreatedDate
    private Timestamp createdAt;

    @OneToMany
    private List<Candidate> candidates;

    //Constructor
    public Company (){

    }

    public Company(int id,
                   @NotNull @Size(max = 100) String name,
                   @NotNull @Size(max = 50) String slug,
                   Timestamp createdAt,
                   List<Candidate> candidates) {

        this.id = id;
        this.name = name;
        this.slug = slug;
        this.createdAt = createdAt;
        this.candidates = candidates;
    }

    //Getters and Setters
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

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }
}