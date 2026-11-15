package com.assettracking.controller;

import com.assettracking.dto.departmentDTO.DepartmentRequestDTO;
import com.assettracking.dto.departmentDTO.DepartmentResponseDTO;
import com.assettracking.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/departments")
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO departmentRequestDTO){
         return ResponseEntity.ok().body(departmentService.createDepartment(departmentRequestDTO));
    }

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartment(){
        return ResponseEntity.ok().body(departmentService.getAllDepartment());
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@Valid @PathVariable Long id){
        return ResponseEntity.ok().body(departmentService.getDepartmentById(id));
    }
}
