package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<CandidateDTO> findById(@PathVariable Long userId,
                                                 @PathVariable Long companyId,
                                                 @PathVariable Long accelerationId){
        Candidate candidate = candidateService.findById(userId, companyId, accelerationId)
                .orElseThrow(()->new ResourceNotFoundException("Candidate"));
        return new ResponseEntity<>(candidateMapper.map(candidate), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> findByAll(@RequestParam Long companyId){
        List<Candidate> candidateList = candidateService.findByCompanyId(companyId);
        return ResponseEntity.ok(candidateMapper.map(candidateList));
    }
}
