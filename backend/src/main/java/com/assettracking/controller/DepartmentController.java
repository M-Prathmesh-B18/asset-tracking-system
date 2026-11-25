package com.assettracking.controller;

import com.assettracking.dto.departmentDTO.DepartmentRequestDTO;
import com.assettracking.dto.departmentDTO.DepartmentResponseDTO;
import com.assettracking.dto.departmentDTO.DepartmentUpdateStatusDTO;
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
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok().body(departmentService.getDepartmentById(id));
    }

    @GetMapping("/departments/name/{deptName}")
    public ResponseEntity<DepartmentResponseDTO> getDepartmentByName( @PathVariable String deptName){
        return ResponseEntity.ok().body(departmentService.getDepartmentByName(deptName));
    }

    @PatchMapping("/departments/{id}/status")
    public ResponseEntity<DepartmentResponseDTO> changeDepartmentStatus(@PathVariable Long id, @Valid  @RequestBody DepartmentUpdateStatusDTO status){
            return  ResponseEntity.ok().body(departmentService.changeDepartmentStatus(id,status));
    }
}
