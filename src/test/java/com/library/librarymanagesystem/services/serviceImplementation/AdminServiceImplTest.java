package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.LibrarymanagesystemApplication;
import com.library.librarymanagesystem.data.models.*;
import com.library.librarymanagesystem.dtos.request.*;
import com.library.librarymanagesystem.dtos.response.*;
import com.library.librarymanagesystem.services.serviceInterface.AdminService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {LibrarymanagesystemApplication.class})
public class AdminServiceImplTest {
    @Autowired
    private AdminService adminService;
    private AdminCreateRequest adminCreateRequest;
    private AdminCreateResponse adminCreateResponse;

    @BeforeEach
    void setUp(){
        adminService.deleteAll();
        adminCreateRequest = new AdminCreateRequest();
        adminCreateRequest.setEmail("folake@gmail.com");
        adminCreateRequest.setFirstName("Tolani");
        adminCreateRequest.setLastName("Adetoun");
        adminCreateRequest.setPassword("6758");
        adminCreateRequest.setPhoneNumber("098254645");
        adminCreateResponse = adminService.createAdmin(adminCreateRequest);
    }
    @AfterEach
    void tearDown(){
        adminService.deleteAll();
    }

    @Test
    public void createAdmin(){
        assertEquals("folake@gmail.com", adminCreateResponse.getEmail());
        System.out.println(adminCreateResponse.getId());
        assertNotNull(adminCreateResponse.getId());
    }
    @Test
    void findAdminsByTheirExistingEmail(){
        Admin findAdmin = adminService.viewAdminByEmail(adminCreateRequest.getEmail());
        assertEquals("folake@gmail.com", findAdmin.getEmail());
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

    @Test
    void findTheListOfAllRegisteredAdmins(){
        AdminCreateRequest adminCreateRequest1 = new AdminCreateRequest();
        adminCreateRequest1.setEmail("fo@gmail.com");
        adminCreateRequest1.setFirstName("Tol");
        adminCreateRequest1.setLastName("Toun");
        adminCreateRequest1.setPassword("244");
        adminCreateRequest1.setPhoneNumber("0982545675");
        adminService.createAdmin(adminCreateRequest1);

        AdminCreateRequest adminCreateRequest2 = new AdminCreateRequest();
        adminCreateRequest2.setEmail("bolaji@gmail.com");
        adminCreateRequest2.setFirstName("Shade");
        adminCreateRequest2.setLastName("Temitop");
        adminCreateRequest2.setPassword("1111");
        adminCreateRequest2.setPhoneNumber("0808254645");
        adminService.createAdmin(adminCreateRequest2);

        List<Admin> adminList = adminService.viewAll();
        assertEquals(3, adminList.size());
        assertEquals("folake@gmail.com", adminList.get(0).getEmail());
    }
    @Test
    void deleteAdminWithTheirProvidedEmail(){
        adminService.deleteAdminByEmail("folake@gmail.com");
        List<Admin> adminList2 = adminService.viewAll();
        assertEquals(0, adminList2.size());
    }

    @Test
    void testThatAdminCanBeUpdated(){
        UpdateAdminRequest updateAdminRequest = new UpdateAdminRequest();
        updateAdminRequest.setId(1L);
        System.out.println(adminCreateResponse.getId());
        updateAdminRequest.setFirstName("Adukke");
        updateAdminRequest.setPhoneNumber("8888");
        updateAdminRequest.setLastName("Atinuke");
        adminService.updateAdmin(updateAdminRequest);
        Admin admin = adminService.viewAdminById(updateAdminRequest.getId());
        assertEquals("Adukke", admin.getFirstName());
        assertEquals("6758", admin.getPassword());
        assertEquals("folake@gmail.com", admin.getEmail());
    }



}
