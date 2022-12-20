package com.library.librarymanagesystem.controller;

import com.library.librarymanagesystem.data.models.Admin;
import com.library.librarymanagesystem.data.repository.AdminRepository;
import com.library.librarymanagesystem.dtos.request.AdminCreateRequest;
import com.library.librarymanagesystem.dtos.request.LoginRequest;
import com.library.librarymanagesystem.dtos.response.AdminCreateResponse;
import com.library.librarymanagesystem.dtos.response.LoginResponse;
import com.library.librarymanagesystem.services.serviceInterface.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<AdminCreateResponse> createAdmin(@RequestBody AdminCreateRequest adminCreateRequest){
        return new ResponseEntity<>(adminService.createAdmin(adminCreateRequest), HttpStatus.OK);
    }

    @GetMapping("/findByEmail/{adminEmail}")
    public ResponseEntity<Admin> findAdminByEmail(@PathVariable String adminEmail){
        return new ResponseEntity<>(adminService.viewAdminByEmail(adminEmail), HttpStatus.OK);
    }

    @GetMapping("/findById/{adminId}")
    public ResponseEntity<Admin> findAdminById(@PathVariable Long adminId){
        return new ResponseEntity<>(adminService.viewAdminById(adminId), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(adminService.adminLogin(loginRequest), HttpStatus.OK);

    }

}
