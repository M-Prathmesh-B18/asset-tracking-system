package com.assettracking.service;

import com.assettracking.dto.departmentDTO.DepartmentRequestDTO;
import com.assettracking.dto.departmentDTO.DepartmentResponseDTO;
import com.assettracking.dto.departmentDTO.DepartmentUpdateStatusDTO;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    public  DepartmentResponseDTO createDepartment(@Valid DepartmentRequestDTO departmentRequestDTO);

    public List<DepartmentResponseDTO> getAllDepartment();

    public DepartmentResponseDTO getDepartmentById(@Valid Long id);

    public DepartmentResponseDTO getDepartmentByName(@Valid String deptName);

    public DepartmentResponseDTO changeDepartmentStatus(Long id, DepartmentUpdateStatusDTO status);
}
