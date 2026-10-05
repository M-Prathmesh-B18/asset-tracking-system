package com.assettracking.repository;

import com.assettracking.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameIgnoreCase(String username);

    boolean existsByEmail(@NotBlank @Email String email);

    boolean existsByUsername(@NotBlank @Size(max=50,message = "role name must not exceed 50 character") String username);

    boolean existsByUsernameIgnoreCase(String username);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByUsernameIgnoreCaseAndIdNot(
            String username,
            Long id);

    boolean existsByEmailIgnoreCaseAndIdNot(
            String email,
            Long id);


}