package com.assettracking.service;

import com.assettracking.dto.userDTO.UserRequestDTO;
import com.assettracking.dto.userDTO.UserResponseDTO;
import com.assettracking.entity.Role;
import com.assettracking.entity.User;
import com.assettracking.exception.DuplicateResourceFoundException;
import com.assettracking.exception.ResourceNotFoundException;
import com.assettracking.repository.RoleRepository;
import com.assettracking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;



    @Override
    public  UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

         if(userRepository.existsByEmail(userRequestDTO.getEmail()))
             throw new DuplicateResourceFoundException("Email already exists: "+userRequestDTO.getEmail());
         if(userRepository.existsByUsername(userRequestDTO.getUsername()))
             throw new DuplicateResourceFoundException("Username already exists: "+userRequestDTO.getUsername());

         Role role=roleRepository.findByRoleNameIgnoreCase(userRequestDTO.getRoleName()).
                 orElseThrow(() -> new ResourceNotFoundException("Role not found: " + userRequestDTO.getRoleName()));;

         User user=modelMapper.map(userRequestDTO,User.class);
         user.setRole(role);

        User savedUser=userRepository.save(user);

         return modelMapper.map(savedUser,UserResponseDTO.class);

    }
}
