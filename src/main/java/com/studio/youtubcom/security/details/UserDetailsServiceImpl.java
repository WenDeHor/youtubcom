package com.studio.youtubcom.security.details;

import com.studio.youtubcom.models.User;
import com.studio.youtubcom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository usersRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = usersRepository.findOneByEmail(email);
        if (user.isPresent()) {
            return new UserDetailsImpl(user.get());
        } else throw new IllegalArgumentException("User not found "+ user.toString());
//        return new
//                UserDetailsImpl(usersRepository.findByEmail(email)
//                .orElseThrow(IllegalArgumentException::new));
    }
}
