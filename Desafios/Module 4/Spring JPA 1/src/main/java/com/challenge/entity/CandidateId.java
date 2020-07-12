package com.challenge.entity;

import lombok.EqualsAndHashCode;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * com.challenge.entity @Embeddable CandidateId
 * @Table candidate
 * public class CandidateID
 * implement Serializable
 *
 * Creates the id of candidate table
 *
 * Relation with other tables:
 * @Table user         - @Column id @ManyToOne
 * @Table acceleration - @Column id @ManyToOne
 * @Table company      - @Column id @ManyToOne
 */

@Embeddable
@EqualsAndHashCode
public class CandidateId implements Serializable {

    @ManyToOne
    private User userId;

    @ManyToOne
    private Acceleration accelerationId;

    @ManyToOne
    private Company companyId;

}

