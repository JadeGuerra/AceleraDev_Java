package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    @GetMapping("/{id}")
    public ResponseEntity<Acceleration> findById(@PathVariable Long id){
        return ResponseEntity.ok(accelerationService.findById(id).get());
    }

    @GetMapping
    public ResponseEntity<List<Acceleration>> fidByAll(@RequestParam Long companyId){
        List<Acceleration> acceleration = accelerationService.findByCompanyId(companyId);
        return new ResponseEntity<>(acceleration, HttpStatus.OK);
    }
}
