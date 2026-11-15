package com.assettracking.repository;

import com.assettracking.dto.departmentDTO.DepartmentResponseDTO;
import com.assettracking.entity.Department;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    boolean existsByDepartmentNameIgnoreCase(String departmentName);

     Optional<Department> findByDepartmentNameIgnoreCase(@NotBlank String departmentName);
}
