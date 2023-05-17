package com.socialmedia.socialmedia.service;

import com.hm.socialmedia.tables.pojos.User;
import com.socialmedia.socialmedia.dto.UserSignInDTO;
import com.socialmedia.socialmedia.mapper.UserSignInInfo;
import com.socialmedia.socialmedia.repository.UserSignInRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSignInService {


    private final UserSignInRepo userSignInRepo;
    private final UserSignInInfo userSignInInfo;

    public UserSignInService(UserSignInRepo userSignInRepo, UserSignInInfo userSignInInfo) {
        this.userSignInRepo = userSignInRepo;
        this.userSignInInfo = userSignInInfo;
    }

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public String registerNewUser(UserSignInDTO userSignInDTO) {
        if (emailExists(userSignInDTO.getEmail())) {
            return "Email has already been registered";
        }

        String password = passwordEncoder.encode(userSignInDTO.getPassword());
        User user = userSignInInfo.userSignInDTOtoUser(userSignInDTO);
        userSignInRepo.insertNewUser(user);

        return "Account is registered successfully";
    }

    private boolean emailExists(String email) {
        return userSignInRepo.findEmail(email);
    }
}
