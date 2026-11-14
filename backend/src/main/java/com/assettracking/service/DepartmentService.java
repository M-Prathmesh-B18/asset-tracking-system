package com.assettracking.service;

import com.assettracking.dto.departmentDTO.DepartmentRequestDTO;
import com.assettracking.dto.departmentDTO.DepartmentResponseDTO;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface DepartmentService {

    public  DepartmentResponseDTO createDepartment(@Valid DepartmentRequestDTO departmentRequestDTO);

    public List<DepartmentResponseDTO> getAllDepartment();
}
