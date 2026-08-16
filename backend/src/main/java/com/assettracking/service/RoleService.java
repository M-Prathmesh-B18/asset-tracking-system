package com.assettracking.service;

import com.assettracking.dto.roleDTO.RoleRequestDto;
import com.assettracking.dto.roleDTO.RoleResponseDto;

import java.util.List;

public interface RoleService {

    public List<RoleResponseDto> getRole();

    public String createRole(RoleRequestDto roleRequestDto);
}
