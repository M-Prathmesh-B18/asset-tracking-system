package com.assettracking.service;

import com.assettracking.dto.roleDTO.RoleRequestDto;
import com.assettracking.dto.roleDTO.RoleResponseDto;
import com.assettracking.entity.Role;
import com.assettracking.exception.ResourceNotFoundException;
import com.assettracking.exception.RoleAlreadyFoundException;
import com.assettracking.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    public String createRole(RoleRequestDto roleRequestDto) {

        if(roleRepository.existsByRoleNameIgnoreCase(roleRequestDto.getRole_name()))
            throw new RoleAlreadyFoundException("Role Already Exists: "+roleRequestDto.getRole_name());

        Role role=modelMapper.map(roleRequestDto,Role.class);
        Role savedRole=roleRepository.save(role);
        if(savedRole==null){
            return "Not Created";
        }
        return "Role Created";
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
                        roleRequestDto.getRole_name(),
                        id
                );

        if(roleNameExists) throw new RoleAlreadyFoundException( "Role name already exists" + roleRequestDto.getRole_name());

        role.setRoleName(roleRequestDto.getRole_name());
        role.setDescription(roleRequestDto.getDescription());

        Role updatedRoleName=roleRepository.save(role);

        return modelMapper.map(updatedRoleName,RoleResponseDto.class);
    }


}
