package com.assettracking.controller;

import
        com.assettracking.dto.roleDTO.RoleRequestDto;
import com.assettracking.dto.roleDTO.RoleResponseDto;
import com.assettracking.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/roles")
    public ResponseEntity<List<RoleResponseDto>> getRole(){
        return ResponseEntity.ok().body(roleService.getRole());
    }

    @PostMapping("/roles")
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody RoleRequestDto roleRequestDto){
        return ResponseEntity.ok().body(roleService.createRole(roleRequestDto));
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<RoleResponseDto> getRoleById(@PathVariable Long id){
        return ResponseEntity.ok().body(roleService.getRoleById(id));
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<RoleResponseDto> updatedRole(@PathVariable Long id, @RequestBody RoleRequestDto roleRequestDto){
        return ResponseEntity.ok().body(roleService.updateRole(id,roleRequestDto));
    }
}
