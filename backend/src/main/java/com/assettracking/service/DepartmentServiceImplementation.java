package com.assettracking.service;

import com.assettracking.dto.departmentDTO.DepartmentRequestDTO;
import com.assettracking.dto.departmentDTO.DepartmentResponseDTO;
import com.assettracking.entity.Department;
import com.assettracking.exception.DuplicateResourceFoundException;
import com.assettracking.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImplementation implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;


    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO) {
         if(departmentRepository.existsByDepartmentNameIgnoreCase(departmentRequestDTO.getDepartmentName()))
             throw new DuplicateResourceFoundException("Department is already exists by this name : "+departmentRequestDTO.getDepartmentName());

         Department newDept=modelMapper.map(departmentRequestDTO, Department.class);

         Department savedDept=departmentRepository.save(newDept);

        return modelMapper.map(savedDept, DepartmentResponseDTO.class);
    }
}
