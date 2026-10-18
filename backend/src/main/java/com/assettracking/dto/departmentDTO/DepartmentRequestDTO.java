package com.assettracking.dto.departmentDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequestDTO {

    @NotBlank
    private String departmentName;

    @NotBlank
    @Size(max = 255,message = "description  must not exceed 255 character")
    private String description;

}
