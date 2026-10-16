package com.assettracking.service;

import com.assettracking.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImplementation implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;


}
