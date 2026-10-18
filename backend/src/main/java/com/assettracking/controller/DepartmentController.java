package com.assettracking.controller;

import com.assettracking.dto.departmentDTO.DepartmentRequestDTO;
import com.assettracking.dto.departmentDTO.DepartmentResponseDTO;
import com.assettracking.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/department")
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO departmentRequestDTO){
         return ResponseEntity.ok().body(departmentService.createDepartment(departmentRequestDTO));
    }
}
