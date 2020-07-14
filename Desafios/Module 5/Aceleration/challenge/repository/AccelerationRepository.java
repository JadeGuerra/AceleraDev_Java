package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    //@Query("select c.acceleration from candidate c join c.company co where co.id = :companyId")
    List<Acceleration> findByCompanyId(Long companyId);
}
