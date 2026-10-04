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
import org.springframework.stereotype.Service;

import java.util.List;

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

         // the user store role as an object not a string , so to fetch the role obj based on role name we use roleRepo

         Role role=roleRepository.findByRoleNameIgnoreCase(userRequestDTO.getRoleName()).
                 orElseThrow(() -> new ResourceNotFoundException("Role not found: " + userRequestDTO.getRoleName()));;

         //modelmapper map the userRequestDto with User obj , but it not mapp the UserRequestDTO.role to User.role because of its type is String and we want obj thats why we use setRole
         User user=modelMapper.map(userRequestDTO,User.class);

         user.setRole(role);

        User savedUser=userRepository.save(user);

         return modelMapper.map(savedUser,UserResponseDTO.class);

    }

    @Override
    public List<UserResponseDTO> getUsers() {
        List<User> userList=userRepository.findAll();

//        List<UserResponseDTO> responseList = new ArrayList<>();
//        for (User user : UserList) {
//
//            UserResponseDTO dto =
//                    modelMapper.map(user, UserResponseDTO.class);
//
//            responseList.add(dto);
//        }
//        return responseList;

         // OR

        // Convert each User entity in the list into a UserResponseDTO
        // using ModelMapper, then collect all converted DTOs into a List.
//        return UserList.stream().map(user -> modelMapper.map(user,UserResponseDTO.class)).toList();
        return userList.stream()
                .map(user -> {

                    UserResponseDTO dto =
                            modelMapper.map(user, UserResponseDTO.class);

                    if (user.getRole() != null) {
                        dto.setRoleName(user.getRole().getRoleName());
                    }

                    return dto;
                })
                .toList();

    }
}
