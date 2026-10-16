package com.assettracking.dto.userDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDTO {
    private String userName;

    private String email;

    private String roleName;

    private String status;


}
