package com.Poster.Cafe.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CafeDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

}
