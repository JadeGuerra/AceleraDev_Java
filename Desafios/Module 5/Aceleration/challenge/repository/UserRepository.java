package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByAccelerationName(String name);

    //@Query("SELECT c.user FROM company co join co.candidate ca join ca.id u WHERE co.id  = :companyId")
    List<User> findByCompanyId(Long companyId);
}
