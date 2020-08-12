package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private SubmissionMapper submissionMapper;

    @GetMapping
    private ResponseEntity<List<SubmissionDTO>> findByAll(@RequestParam Long challengeId,
                                                          @RequestParam Long accelerationId){
        List<Submission> submission = submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
        return ResponseEntity.ok(submissionMapper.map(submission));
    }
}
