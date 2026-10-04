package com.assettracking.controller;

import com.assettracking.dto.userDTO.UserRequestDTO;
import com.assettracking.dto.userDTO.UserResponseDTO;
import com.assettracking.service.UserServiceImplementation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImplementation userServiceimplementation;

    @PostMapping("users")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.ok().body(userServiceimplementation.createUser(userRequestDTO));
    }

    @GetMapping("users")
    public ResponseEntity<List<UserResponseDTO>>getUsers(){
        return ResponseEntity.ok().body(userServiceimplementation.getUsers());
    }
}
