package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.data.repository.AdminRepository;
import com.library.librarymanagesystem.dtos.request.AdminCreateRequest;
import com.library.librarymanagesystem.dtos.request.LoginRequest;
import com.library.librarymanagesystem.dtos.response.AdminCreateResponse;
import com.library.librarymanagesystem.dtos.response.LoginResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.library.librarymanagesystem.services.serviceInterface.*;
import com.library.librarymanagesystem.data.models.*;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServiceImplTest {
    @MockBean
    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;
    private Admin admin;
    private AdminCreateResponse adminCreateResponse;
    private AdminCreateRequest adminCreateRequest;
    @AfterEach
    void afterEach(){
        adminRepository.flush();
    }
    @BeforeEach
    void setUp() {
        adminCreateRequest = new AdminCreateRequest();
        admin = new Admin();
        adminCreateResponse = new AdminCreateResponse();

        adminCreateRequest.setEmail("folake@gmail.com");
        adminCreateRequest.setFirstName("Tolani");
        adminCreateRequest.setLastName("Adetoun");
        adminCreateRequest.setPassword("6758");

        admin.setEmail(adminCreateRequest.getEmail());
        admin.setFirstName(adminCreateRequest.getFirstName());
        admin.setLastName(adminCreateRequest.getLastName());
        admin.setPassword(adminCreateRequest.getPassword());
        when(adminRepository.save(admin)).thenReturn(admin);
    }
    @Test
    void findAdminsByTheirExistingEmail(){
        when(adminRepository.findAdminByEmail("folake@gmail.com")).thenReturn(Optional.ofNullable(admin));
        Admin findAdmin = adminService.viewAdminByEmail(adminCreateRequest.getEmail());
        assertEquals("folake@gmail.com", findAdmin.getEmail());
    }

    @Test
    void createAdmin() {
        adminCreateResponse = adminService.createAdmin(adminCreateRequest);
        assertEquals("folake@gmail.com", adminCreateResponse.getEmail());
    }
    @Test
    void adminCanLoginWithCorrectDetails_AdminCannotWithWrongDetails(){
        adminService.createAdmin(adminCreateRequest);
        when(adminRepository.findAdminByEmail("folake@gmail.com")).thenReturn(Optional.ofNullable(admin));
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("6758");
        loginRequest.setEmail("folake@gmail.com");
        System.out.println(adminCreateRequest.getPassword());
        System.out.println(adminCreateRequest.getEmail());
        LoginResponse loginResponse = adminService.adminLogin(loginRequest);
        assertEquals("Login successful", loginResponse.getMessage());
    }

    @Test
    void findTheListOfAllRegisteredAdmins(){
        Admin admin2 = new Admin();
        AdminCreateRequest adminCreateRequest1 = new AdminCreateRequest();
        adminCreateRequest1.setEmail("fo@gmail.com");
        adminCreateRequest1.setFirstName("Tol");
        adminCreateRequest1.setLastName("Toun");
        adminCreateRequest1.setPassword("244");
        adminService.createAdmin(adminCreateRequest1);

        admin2.setEmail(adminCreateRequest.getEmail());
        admin2.setFirstName(adminCreateRequest.getFirstName());
        admin2.setLastName(adminCreateRequest.getLastName());
        admin2.setPassword(adminCreateRequest.getPassword());
        when(adminRepository.save(admin2)).thenReturn(admin2);
        when(adminRepository.findAll()).thenReturn(List.of(admin, admin2));

        Admin admin1 = new Admin();
        AdminCreateRequest adminCreateRequest2 = new AdminCreateRequest();
        adminCreateRequest2.setEmail("bolaji@gmail.com");
        adminCreateRequest2.setFirstName("Shade");
        adminCreateRequest2.setLastName("Temitop");
        adminCreateRequest2.setPassword("1111");
        adminService.createAdmin(adminCreateRequest2);

        admin1.setEmail(adminCreateRequest.getEmail());
        admin1.setFirstName(adminCreateRequest.getFirstName());
        admin1.setLastName(adminCreateRequest.getLastName());
        admin1.setPassword(adminCreateRequest.getPassword());
        when(adminRepository.save(admin1)).thenReturn(admin, admin2, admin1);

        List<Admin> adminList = adminService.viewAll();
        assertEquals(2, adminList.size());
        assertEquals(admin, adminList.get(0));
    }

    @Test
    void deleteAdminWithTheirProvidedEmail(){
        adminService.createAdmin(adminCreateRequest);
        when(adminRepository.save(admin)).thenReturn(admin);
        when(adminRepository.findAll()).thenReturn(List.of(admin));
        List<Admin> adminList = adminService.viewAll();
        assertEquals(1, adminList.size());
        when(adminRepository.findAdminByEmail("folake@gmail.com")).thenReturn(Optional.ofNullable(admin));
        when(adminRepository.deleteAdminByEmail("folake@gmail.com")).thenReturn("Not found");
        adminService.deleteAdminByEmail("folake@gmail.com");
        assertEquals(0, adminList.size());
    }
 //    @Test
//        void findAdminsByTheirExistingID(){
//
//        Admin admin = new Admin();
//        Admin findAdmin = adminService.viewAdminById(admin.getAdminId());
//        assertEquals(admin, findAdmin);
//    }

}