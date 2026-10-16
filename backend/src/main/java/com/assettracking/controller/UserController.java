package com.assettracking.controller;

import com.assettracking.dto.userDTO.UserRequestDTO;
import com.assettracking.dto.userDTO.UserResponseDTO;
import com.assettracking.dto.userDTO.UserUpdateRequestDTO;
import com.assettracking.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.ok().body(userService.createUser(userRequestDTO));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>>getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@Valid @PathVariable Long id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@Valid @PathVariable Long id, @RequestBody UserUpdateRequestDTO  req){
        return ResponseEntity.ok().body(userService.updateUser(id,req));
    }

    @PatchMapping("/{id}/role")
    public ResponseEntity<UserResponseDTO> assignRoleToUser(@Valid @PathVariable Long id, @RequestBody String role){
        return ResponseEntity.ok().body(userService.assignRoleToUser(id,role));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<UserResponseDTO> changeUserStatus(@Valid @PathVariable Long id , @RequestBody String status){
        return ResponseEntity.ok().body(userService.changeUserStatus(id,status));
    }
}
