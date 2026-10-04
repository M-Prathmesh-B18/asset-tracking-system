package com.assettracking.repository;

import com.assettracking.entity.Role;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    boolean existsByRoleNameIgnoreCase(String roleName);

    boolean existsByRoleNameIgnoreCaseAndIdNot(
            String roleName,
            Long id
    );

    Optional<Role> findByRoleNameIgnoreCase(@NotBlank String roleName);
}
