package com.Poster.Cafe.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRoleDTO {

    @JsonProperty("role")
    private String role;

}