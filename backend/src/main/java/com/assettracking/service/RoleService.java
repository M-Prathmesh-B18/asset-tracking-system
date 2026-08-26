package com.assettracking.service;

import com.assettracking.dto.roleDTO.RoleRequestDto;
import com.assettracking.dto.roleDTO.RoleResponseDto;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface RoleService {

    public List<RoleResponseDto> getRole();

    public RoleResponseDto createRole(RoleRequestDto roleRequestDto);

    public RoleResponseDto getRoleById(Long id);

    public RoleResponseDto updateRole(Long id, RoleRequestDto roleRequestDto);
}
