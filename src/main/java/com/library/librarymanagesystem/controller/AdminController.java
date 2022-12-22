package com.library.librarymanagesystem.controller;

import com.library.librarymanagesystem.data.models.Admin;
import java.util.*;


import com.library.librarymanagesystem.dtos.request.*;
import com.library.librarymanagesystem.dtos.response.*;
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

    @PostMapping("/createAdmin")
    public ResponseEntity<AdminCreateResponse> createAdmin(@RequestBody AdminCreateRequest adminCreateRequest){
        return new ResponseEntity<>(adminService.createAdmin(adminCreateRequest), HttpStatus.OK);
    }

    @PostMapping("/loginAdmin")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(adminService.adminLogin(loginRequest), HttpStatus.OK);

    }
    @PutMapping("/updateAdmin")
    public ResponseEntity<UpdateAdminResponse> updateAdmin(@RequestBody UpdateAdminRequest updateAdminRequest){
        return new ResponseEntity<>(adminService.updateAdmin(updateAdminRequest), HttpStatus.OK);
    }

    @PutMapping("/updateAdminByEmail")
    public ResponseEntity<UpdateAdminResponse> updatedAdminByEmail(@RequestBody UpdateAdminRequest updateAdminRequest){
        return new ResponseEntity<>(adminService.updateAdminByEmail(updateAdminRequest), HttpStatus.OK);
    }
    @GetMapping("/findByEmail/{adminEmail}")
    public ResponseEntity<Admin> findAdminByEmail(@PathVariable String adminEmail){
        return new ResponseEntity<>(adminService.viewAdminByEmail(adminEmail), HttpStatus.OK);
    }

    @GetMapping("/findById/{adminId}")
    public ResponseEntity<Admin> findAdminById(@PathVariable Long adminId){
        return new ResponseEntity<>(adminService.viewAdminById(adminId), HttpStatus.OK);
    }
    @GetMapping("/adminList")
    public ResponseEntity<List<Admin>> adminList(){
        return new ResponseEntity<>(adminService.viewAll(), HttpStatus.OK);
    }
    @GetMapping("/deleteByEmail/{email}")
    public ResponseEntity<String> deleteAdminByEmail(@PathVariable String email){
        return new ResponseEntity<>(adminService.deleteAdminByEmail(email), HttpStatus.OK);
    }
    @GetMapping("/deleteAllAdmin")
    public ResponseEntity<String> deleteAllAdmin(){
        return new ResponseEntity<>(adminService.deleteAll(), HttpStatus.OK);
    }

}
