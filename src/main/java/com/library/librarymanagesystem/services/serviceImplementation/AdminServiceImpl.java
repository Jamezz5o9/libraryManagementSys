package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.data.models.Admin;
import com.library.librarymanagesystem.data.repository.AdminRepository;
import com.library.librarymanagesystem.dtos.request.AdminCreateRequest;
import com.library.librarymanagesystem.dtos.request.LoginRequest;
import com.library.librarymanagesystem.dtos.response.AdminCreateResponse;
import com.library.librarymanagesystem.dtos.response.LoginResponse;
import com.library.librarymanagesystem.exception.AdminException;
import com.library.librarymanagesystem.exception.LoginDetailsException;
import com.library.librarymanagesystem.services.serviceInterface.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public AdminCreateResponse createAdmin(AdminCreateRequest adminCreateRequest) {
        if(adminRepository.findAdminByEmail(adminCreateRequest.getEmail()).isPresent()) throw new AdminException("Admin already exist");
        else{
            Admin admin = Admin.builder()
                    .firstName(adminCreateRequest.getFirstName())
                    .lastName(adminCreateRequest.getLastName())
                    .password(adminCreateRequest.getPassword())
                    .email(adminCreateRequest.getEmail())
                    .build();
            Admin savedAdmin = adminRepository.save(admin);
            return mapper.map(savedAdmin, AdminCreateResponse.class);
        }

    }

    @Override
    public Admin viewAdminByEmail(String email) {
        return adminRepository.findAdminByEmail(email).orElseThrow(() -> new AdminException("admin not found"));
    }

    @Override
    public LoginResponse adminLogin(LoginRequest loginRequest){
        Admin foundAdmin = viewAdminByEmail(loginRequest.getEmail());
        if(!Objects.equals(loginRequest.getEmail(), foundAdmin.getEmail())) throw new LoginDetailsException(loginRequest.getEmail() + "doesn't exist");
        else if (!Objects.equals(foundAdmin.getPassword(), loginRequest.getPassword())) throw new LoginDetailsException("Incorrect password, pls try again!!!");
        else{
            return mapper.map(foundAdmin, LoginResponse.class);
        }
    }

    @Override
    public List<Admin> viewAll() {
        return adminRepository.findAll();
    }

    @Override
    public String deleteAdminByEmail(String email){
        Admin admin = viewAdminByEmail(email);
        adminRepository.delete(admin);
        return "Email deleted succesfully";
    }

    @Override
    public Admin viewAdminById(Long id){
        return adminRepository.findById(id).orElseThrow(() -> new AdminException("Admin does not exist"));
    }

}
