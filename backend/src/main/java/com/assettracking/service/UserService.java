package com.assettracking.service;

import com.assettracking.dto.userDTO.UserRequestDTO;
import com.assettracking.dto.userDTO.UserResponseDTO;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    public List<UserResponseDTO> getUsers();
}
