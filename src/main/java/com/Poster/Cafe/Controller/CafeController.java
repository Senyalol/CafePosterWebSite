package com.Poster.Cafe.Controller;

import com.Poster.Cafe.DTO.CafeDTO;
import com.Poster.Cafe.Service.CafeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/cafe")
public class CafeController {

    private final CafeService cafeService;

    @Autowired
    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    //Получит данные о кафе
    //Адрес маппинга http://localhost:8080/api/cafe
    @GetMapping
    public List<CafeDTO> getCafeData(){
        return cafeService.getCafeData();
    }

    //Обновить данные о кафе
    //Адрес маппинга http://localhost:8080/api/cafe
    @PatchMapping
    public CafeDTO updateCafe(@RequestBody CafeDTO cafeDTO){
        return cafeService.patchCafeById(cafeDTO);
    }

}
