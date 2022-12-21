package com.library.librarymanagesystem.services.serviceInterface;

import com.library.librarymanagesystem.data.models.Admin;
import com.library.librarymanagesystem.dtos.request.AdminCreateRequest;
import com.library.librarymanagesystem.dtos.request.LoginRequest;
import com.library.librarymanagesystem.dtos.response.AdminCreateResponse;
import com.library.librarymanagesystem.dtos.response.LoginResponse;

import java.util.List;

public interface AdminService {
    AdminCreateResponse createAdmin(AdminCreateRequest adminCreateRequest);
    Admin viewAdminByEmail(String email);

    Admin viewAdminById(Long id);
    LoginResponse adminLogin(LoginRequest loginRequest);
    List<Admin> viewAll();

    String deleteAdminByEmail(String email);
}
