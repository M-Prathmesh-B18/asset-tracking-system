package com.assettracking.service;

import com.assettracking.dto.roleDTO.RoleRequestDto;
import com.assettracking.dto.roleDTO.RoleResponseDto;
import com.assettracking.dto.userDTO.UserResponseDTO;
import com.assettracking.entity.Role;
import com.assettracking.exception.ResourceNotFoundException;
import com.assettracking.exception.RoleAlreadyFoundException;
import com.assettracking.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

import static org.aspectj.runtime.internal.Conversions.longValue;

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
    public RoleResponseDto createRole(RoleRequestDto roleRequestDto) {

        if(roleRepository.existsByRoleNameIgnoreCase(roleRequestDto.getRoleName()))
            throw new RoleAlreadyFoundException("Role Already Exists: "+roleRequestDto.getRoleName());

        Role role=modelMapper.map(roleRequestDto,Role.class);
        Role savedRole=roleRepository.save(role);


        return modelMapper.map(savedRole,RoleResponseDto.class);
    }

    @Override
    public RoleResponseDto getRoleById(Long id) {
        Role role= roleRepository.findById((Long) id).
                orElseThrow(()-> new ResourceNotFoundException("Role not found for this id: "+id));

        return  modelMapper.map(role,RoleResponseDto.class);
    }

    @Override
    public RoleResponseDto updateRole(Long id, RoleRequestDto roleRequestDto) {
        Role role=roleRepository.findById( (Long) id ).orElseThrow( ()-> new ResourceNotFoundException("Role not found for this id: "+id));

        boolean roleNameExists =
                roleRepository.existsByRoleNameIgnoreCaseAndIdNot(
                        roleRequestDto.getRoleName(),
                        id
                );

        if(roleNameExists) throw new RoleAlreadyFoundException( "Role name already exists" + roleRequestDto.getRoleName());

        role.setRoleName(roleRequestDto.getRoleName());
        role.setDescription(roleRequestDto.getDescription());

        Role updatedRoleName=roleRepository.save(role);

        return modelMapper.map(updatedRoleName,RoleResponseDto.class);
    }


}
