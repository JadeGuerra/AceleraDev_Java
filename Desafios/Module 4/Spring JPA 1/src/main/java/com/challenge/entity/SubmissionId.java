package com.challenge.entity;


import lombok.EqualsAndHashCode;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * com.challenge.entity @Embeddable SubmissionId
 * @Table submission
 * public class SubmissionId
 * implement Serializable
 *
 * Creates the id of submission table
 *
 * Relation with other tables:
 * @Table user         - @Column id @ManyToOne
 * @Table challenge    - @Column id @ManyToOne
 */

@Embeddable
@EqualsAndHashCode
public class SubmissionId implements Serializable {

    @ManyToOne
    private User userId;

    @ManyToOne
    private Challenge challengeId;
}
