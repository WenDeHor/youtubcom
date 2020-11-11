package com.studio.youtubcom.service;

import com.studio.youtubcom.forms.UserForm;
import com.studio.youtubcom.models.Role;
import com.studio.youtubcom.models.State;
import com.studio.youtubcom.models.User;
import com.studio.youtubcom.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        User userByRole = usersRepository.findUserByRole(Role.ADMIN);
        if(userByRole == null){
            User user = User.builder()
                    .password(hashPassword)
                    .login(userForm.getLogin())
                    .email(userForm.getEmail())
                    .role(Role.ADMIN)
                    .state(State.ACTIVE)
                    .build();
            usersRepository.save(user);
        } else {
            User user = User.builder()
                    .password(hashPassword)
                    .login(userForm.getLogin())
                    .email(userForm.getEmail())
                    .role(Role.USER)
                    .state(State.ACTIVE)
                    .build();
            usersRepository.save(user);
        }


    }
}
