package com.Poster.Cafe.Mapper;

import com.Poster.Cafe.DTO.CafeDTO;
import org.springframework.stereotype.Component;
import com.Poster.Cafe.Entity.Cafe;

@Component
public class CafeMapper {

    //Из DTO в сущность
    public Cafe toEntity(CafeDTO cafeDTO) {

        Cafe cafe = new Cafe();

        cafe.setId(cafeDTO.getId());
        cafe.setName(cafeDTO.getName());

        return cafe;
    }

    //Из сущности в DTO
    public CafeDTO toDTO(Cafe cafe) {

        CafeDTO cafeDTO = new CafeDTO();

        cafeDTO.setId(cafe.getId());
        cafeDTO.setName(cafe.getName());

        return cafeDTO;
    }

}
