package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id){
        return new ResponseEntity<>(companyService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Company")),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Company>> findByAll(@RequestParam(required = false) Long accelerationId,
                                                   @RequestParam(required = false) Long userId){
        if(Objects.nonNull(accelerationId))
            return ResponseEntity.ok(companyService.findByAccelerationId(accelerationId));
        if(Objects.nonNull(userId))
            return ResponseEntity.ok(companyService.findByUserId(userId));
        return ResponseEntity.badRequest().build();
    }
}
