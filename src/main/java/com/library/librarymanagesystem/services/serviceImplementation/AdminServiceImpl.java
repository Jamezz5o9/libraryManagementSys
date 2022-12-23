package com.library.librarymanagesystem.services.serviceImplementation;

import com.library.librarymanagesystem.data.models.Admin;
import com.library.librarymanagesystem.data.models.Book;
import com.library.librarymanagesystem.data.repository.AdminRepository;
import com.library.librarymanagesystem.dtos.request.AddBookRequest;
import com.library.librarymanagesystem.dtos.request.AdminCreateRequest;
import com.library.librarymanagesystem.dtos.request.LoginRequest;
import com.library.librarymanagesystem.dtos.request.UpdateAdminRequest;
import com.library.librarymanagesystem.dtos.response.AddBookResponse;
import com.library.librarymanagesystem.dtos.response.AdminCreateResponse;
import com.library.librarymanagesystem.dtos.response.LoginResponse;
import com.library.librarymanagesystem.dtos.response.UpdateAdminResponse;
import com.library.librarymanagesystem.exception.AdminException;
import com.library.librarymanagesystem.exception.AuthorException;
import com.library.librarymanagesystem.exception.LoginDetailsException;
import com.library.librarymanagesystem.services.serviceInterface.AdminService;
import com.library.librarymanagesystem.services.serviceInterface.BookService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
@Transactional
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public AdminCreateResponse createAdmin(AdminCreateRequest adminCreateRequest) {
        if(adminRepository.findAdminByEmail(adminCreateRequest.getEmail().toLowerCase()).isPresent()) throw  new AuthorException("Email exist");
        Admin admin = Admin.builder()
                .firstName(adminCreateRequest.getFirstName())
                .lastName(adminCreateRequest.getLastName())
                .email(adminCreateRequest.getEmail())
                .password(adminCreateRequest.getPassword())
                .phoneNumber(adminCreateRequest.getPhoneNumber())
                .build();
        Admin savedAdmin = adminRepository.save(admin);
        return mapper.map(savedAdmin, AdminCreateResponse.class);
    }

    public UpdateAdminResponse updateAdmin(UpdateAdminRequest updateAdminRequest){
        if(adminRepository.findAdminById(updateAdminRequest.getId()).isEmpty()) throw new AdminException(updateAdminRequest.getId() + " can't be empty");
        Admin createAdmin = viewAdminById(updateAdminRequest.getId());
        if (updateAdminRequest.getFirstName() != null) createAdmin.setFirstName(updateAdminRequest.getFirstName());
        if (updateAdminRequest.getPhoneNumber() != null) createAdmin.setPhoneNumber(updateAdminRequest.getPhoneNumber());
        if (updateAdminRequest.getLastName() != null) createAdmin.setLastName(updateAdminRequest.getLastName());
        Admin savedAdmin = adminRepository.save(createAdmin);
        return mapper.map(savedAdmin, UpdateAdminResponse.class);

    }

    @Override
    public UpdateAdminResponse updateAdminByEmail(UpdateAdminRequest updateAdminRequest) {
        if(adminRepository.findAdminByEmail(updateAdminRequest.getEmail()).isEmpty()) throw new AdminException(updateAdminRequest.getEmail() + " is not found");
        Admin foundAdmin = viewAdminByEmail(updateAdminRequest.getEmail());
        if (updateAdminRequest.getFirstName() != null) foundAdmin.setFirstName(updateAdminRequest.getFirstName());
        if (updateAdminRequest.getPhoneNumber() != null) foundAdmin.setPhoneNumber(updateAdminRequest.getPhoneNumber());
        if (updateAdminRequest.getLastName() != null) foundAdmin.setLastName(updateAdminRequest.getLastName());
        Admin savedAdmin = adminRepository.save(foundAdmin);
        return mapper.map(savedAdmin, UpdateAdminResponse.class);
    }

    @Override
    public AddBookResponse addBook(AddBookRequest addBookRequest) {


    }

    @Override
    public Admin viewAdminByEmail(String email) {
        return adminRepository.findAdminByEmail(email).orElseThrow(() -> new AdminException("admin not found"));
    }

    @Override
    public LoginResponse adminLogin(LoginRequest loginRequest){
        Admin foundAdmin = viewAdminByEmail(loginRequest.getEmail());
        if(!Objects.equals(loginRequest.getEmail(), foundAdmin.getEmail())) throw new LoginDetailsException(loginRequest.getEmail() + " doesn't exist");
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
        adminRepository.deleteAdminByEmail(email);
        return "Email deleted successfully";
    }

    @Override
    public String deleteAll() {
        adminRepository.deleteAll();
        return "All Admin deleted successfully";
    }

    @Override
    public Admin viewAdminById(Long id){
        return adminRepository.findAdminById(id).orElseThrow(() -> new AdminException("Admin with " + id + " does not exist"));
    }
}
