package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.apache.logging.log4j.util.Strings;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User")),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> findByAll(@RequestParam(required = false) String accelerationName,
                                                @RequestParam(required = false) Long companyId){
        if(Strings.isNotBlank(accelerationName))
            return ResponseEntity.ok(userService.findByAccelerationName(accelerationName));
        if(Objects.nonNull(companyId))
            return ResponseEntity.ok(userService.findByCompanyId(companyId));
        return ResponseEntity.notFound().build();
    }
}
