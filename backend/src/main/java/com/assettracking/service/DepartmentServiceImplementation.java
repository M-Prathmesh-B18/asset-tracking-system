package com.assettracking.service;

import com.assettracking.dto.departmentDTO.DepartmentRequestDTO;
import com.assettracking.dto.departmentDTO.DepartmentResponseDTO;
import com.assettracking.dto.departmentDTO.DepartmentUpdateStatusDTO;
import com.assettracking.entity.Department;
import com.assettracking.entity.type.Status;
import com.assettracking.exception.DuplicateResourceFoundException;
import com.assettracking.exception.ResourceNotFoundException;
import com.assettracking.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImplementation implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;


    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO) {
        if (departmentRepository.existsByDepartmentNameIgnoreCase(departmentRequestDTO.getDepartmentName()))
            throw new DuplicateResourceFoundException("Department is already exists by this name : " + departmentRequestDTO.getDepartmentName());

        Department newDept = modelMapper.map(departmentRequestDTO, Department.class);

        Department savedDept = departmentRepository.save(newDept);

        return modelMapper.map(savedDept, DepartmentResponseDTO.class);
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartment() {
        List<Department> deptList = departmentRepository.findAll();

        return deptList.stream().map(dept -> modelMapper.map(dept, DepartmentResponseDTO.class)).toList();
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(Long id) {
        Department dept = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found by this id : " + id));

        return modelMapper.map(dept, DepartmentResponseDTO.class);
    }

    @Override
    public DepartmentResponseDTO getDepartmentByName(String deptName) {

        Department dept = departmentRepository.findByDepartmentNameIgnoreCase(deptName).orElseThrow(() -> new ResourceNotFoundException("Department not found by this name : " + deptName));
        return modelMapper.map(dept, DepartmentResponseDTO.class);
    }

    @Override
    public DepartmentResponseDTO changeDepartmentStatus(Long id, DepartmentUpdateStatusDTO status) {
        Department dept = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found by this id: " + id));

        dept.setStatus(status.getStatus());

        Department updatedDep=departmentRepository.save(dept);
        return modelMapper.map(updatedDep, DepartmentResponseDTO.class);
    }
}
