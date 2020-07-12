package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

/**
 * com.challenge.entity @Entity(name = "user")
 * @Table user
 * public class User
 * extends Object
 *
 * Columns:
 * id         - int @OneToMany
 * full_name  - varchar (100)
 * email      - varchar (100)
 * nickname   - varchar (50)
 * password   - varchar (255)
 * created_at - timestamp
 *
 * Bilateral relation with
 *
 * @Table submission - @OneToMany
 * @Table candidate  - @OneToMany
 */

@Entity
@Table (name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="full_name")
    @Size (max = 100)
    @NotNull
    private String fullName;

    @Column
    @Size (max = 100)
    @NotNull
    @Email
    private String email;

    @Column
    @Size (max = 50)
    @NotNull
    private String nickname;

    @Column
    @Size (max = 255)
    @NotNull
    private String password;

    @Column(name="created_at")
    @NotNull
    @CreatedDate
    private Timestamp createdAt;

    @OneToMany
    private List<Submission> submissions;

    @OneToMany
    private List<Candidate> candidates;

    //Contructor
    public User (){

    }

    public User(@NotNull int id,
                @Size(max = 100) @NotNull String fullName,
                @Size(max = 100) @NotNull @Email String email,
                @Size(max = 50) @NotNull String nickname,
                @Size(max = 255) @NotNull String password,
                @NotNull Timestamp createdAt,
                List<Submission> submissions,
                List<Candidate> candidates) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.createdAt = createdAt;
        this.submissions = submissions;
        this.candidates = candidates;
    }


    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }
}


