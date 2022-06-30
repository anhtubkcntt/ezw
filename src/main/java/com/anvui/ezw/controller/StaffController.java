package com.anvui.ezw.controller;

import com.anvui.ezw.model.entity.StaffEntity;
import com.anvui.ezw.repository.jpa.StaffJpaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ezw/v1/staff")
@Slf4j
public class StaffController {

    @Autowired
    StaffJpaRepo staffJpaRepo;

    @GetMapping
    public ResponseEntity<StaffEntity> getStaffEntity() {
        try {
            return ResponseEntity.ok(staffJpaRepo.findAll().get(0));
        } catch (Exception exception) {
            log.error("getOtpInfo exception message: {}", exception.getMessage());
            return ResponseEntity.noContent().build();
        }
    }
}
