package com.assettracking.service;

import com.assettracking.dto.roleDTO.RoleRequestDto;
import com.assettracking.dto.roleDTO.RoleResponseDto;
import com.assettracking.entity.Role;
import com.assettracking.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImplementation implements RoleService{

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<RoleResponseDto> getRole() {
        List<Role> roles =roleRepository.findAll();
        return roles.stream().map(role -> modelMapper.map(role,RoleResponseDto.class)).toList();
    }

    @Override
    public String createRole(RoleRequestDto roleRequestDto) {
        Role role=modelMapper.map(roleRequestDto,Role.class);
        Role savedRole=roleRepository.save(role);
        if(savedRole==null){
            return "Not Created";
        }
        return "Role Created";
    }


}
