package com.assettracking.dto.ErrorDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDTO {

    private int status;
    private String msg;

    public ErrorResponseDTO(int status,String msg){
        this.status=status;
        this.msg=msg;
    }

}
