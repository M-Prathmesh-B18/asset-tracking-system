package com.assettracking.service;

import com.assettracking.dto.departmentDTO.DepartmentRequestDTO;
import com.assettracking.dto.departmentDTO.DepartmentResponseDTO;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

public interface DepartmentService {

    public  DepartmentResponseDTO createDepartment(@Valid DepartmentRequestDTO departmentRequestDTO);
}
