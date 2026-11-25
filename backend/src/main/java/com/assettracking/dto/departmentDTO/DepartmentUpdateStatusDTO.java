package com.assettracking.dto.departmentDTO;

import com.assettracking.entity.type.Status;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentUpdateStatusDTO {
    @NotNull(message = "Status is required")
    private Status status;
}
