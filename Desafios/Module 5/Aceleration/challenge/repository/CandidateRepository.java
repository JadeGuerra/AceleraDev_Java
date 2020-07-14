package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.From;
import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    //@Query("SELECT c FROM company co JOIN co.candidate c JOIN c.id WHERE co.id = :companyId")
    List<Candidate> findCompanyId(Long companyId);

   // @Query("SELECT c FROM acceleration a JOIN a.candidate c JOIN c.id WHERE a.id = :accelerationId")
    List<Candidate> findByAccelerationId(Long accelerationId);

    Optional<Candidate> findById(CandidateId id);
}
