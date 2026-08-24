package com.assettracking.controller;

import com.assettracking.dto.roleDTO.RoleRequestDto;
import com.assettracking.dto.roleDTO.RoleResponseDto;
import com.assettracking.service.RoleServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoleController {

    private final RoleServiceImplementation roleServiceImplementation;

    @GetMapping("/roles")
    public ResponseEntity<List<RoleResponseDto>> getRole(){
        return ResponseEntity.ok().body(roleServiceImplementation.getRole());
    }

    @PostMapping("/roles")
    public ResponseEntity<String> createRole(@RequestBody RoleRequestDto roleRequestDto){
        return ResponseEntity.ok().body(roleServiceImplementation.createRole(roleRequestDto));
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<RoleResponseDto> getRoleById(@PathVariable Long id){
        return ResponseEntity.ok().body(roleServiceImplementation.getRoleById(id));
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<RoleResponseDto> updatedRole(@PathVariable Long id, @RequestBody RoleRequestDto roleRequestDto){
        return ResponseEntity.ok().body(roleServiceImplementation.updateRole(id,roleRequestDto));
    }
}
