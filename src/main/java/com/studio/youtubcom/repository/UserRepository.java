package com.studio.youtubcom.repository;

import com.studio.youtubcom.models.Role;
import com.studio.youtubcom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
    User findUserByRole(Role role);
}
