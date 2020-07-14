package com.challenge.service.interfaces;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class SubmissionServiceImpl implements SubmissionServiceInterface{

    @Autowired
    private SubmissionRepository submissionRepository;

    //tem q dar erro nesse.
    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        return null;
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        Long id = challengeId + accelerationId;
        return submissionRepository.findByChallengeIdAndAccelerationId(id);
    }

    @Override
    public Submission save(Submission object) {
        return this.submissionRepository.save(object);
    }
}
