package com.assettracking.service;

import com.assettracking.dto.userDTO.UserRequestDTO;
import com.assettracking.dto.userDTO.UserResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO);
}
