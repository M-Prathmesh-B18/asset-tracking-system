package com.assettracking.repository;

import com.assettracking.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    boolean existsByDepartmentNameIgnoreCase(String departmentName);
}
