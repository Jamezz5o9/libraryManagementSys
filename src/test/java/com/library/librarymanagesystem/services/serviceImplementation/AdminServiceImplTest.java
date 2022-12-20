package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.data.repository.AdminRepository;
import com.library.librarymanagesystem.dtos.request.AdminCreateRequest;
import com.library.librarymanagesystem.dtos.request.LoginRequest;
import com.library.librarymanagesystem.dtos.response.AdminCreateResponse;
import com.library.librarymanagesystem.dtos.response.LoginResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.library.librarymanagesystem.services.serviceInterface.*;
import com.library.librarymanagesystem.data.models.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServiceImplTest {
    @MockBean
    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;

    private AdminCreateRequest adminCreateRequest;

    @BeforeEach
    void setUp() {
        adminCreateRequest = new AdminCreateRequest();
        adminCreateRequest.setEmail("folake@gmail.com");
        adminCreateRequest.setFirstName("Tolani");
        adminCreateRequest.setLastName("Adetoun");
        adminCreateRequest.setPassword("6758");

        Admin admin = new Admin();
        admin.setEmail(adminCreateRequest.getEmail());
        admin.setFirstName(adminCreateRequest.getFirstName());
        admin.setLastName(adminCreateRequest.getLastName());
        admin.setPassword(adminCreateRequest.getPassword());
        when(adminRepository.save(admin)).thenReturn(admin);
        when(adminRepository.findAdminByEmail("folake@gmail.com")).thenReturn(Optional.ofNullable(admin));
        when(adminRepository.findById(1L)).thenReturn(Optional.ofNullable(admin));
    }

    @Test
    void createAdmin() {
        AdminCreateResponse adminCreateResponse = adminService.createAdmin(adminCreateRequest);
        assertEquals("folake@gmail.com", adminCreateResponse.getEmail());
    }

    @Test
    void findAdminsByTheirExistingEmail(){
        Admin findAdmin = adminService.viewAdminByEmail(adminCreateRequest.getEmail());
        assertEquals("folake@gmail.com", findAdmin.getEmail());
    }

    @Test
    void findAdminsByTheirExistingID(){
        Admin admin = new Admin();
        Admin findAdmin = adminService.viewAdminById(admin.getAdminId());
        assertEquals(admin, findAdmin);
    }

    @Test
    void adminCanLoginWithCorrectDetails_AdminCannotWithWrongDetails(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("6758");
        loginRequest.setEmail("folake@gmail.com");
        System.out.println(adminCreateRequest.getPassword());
        System.out.println(adminCreateRequest.getEmail());
        LoginResponse loginResponse = adminService.adminLogin(loginRequest);
        assertEquals("Login successful", loginResponse.getMessage());
    }

}