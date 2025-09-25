package com.Poster.Cafe.Service;

import com.Poster.Cafe.DTO.CafeDTO;
import com.Poster.Cafe.Entity.Cafe;
import com.Poster.Cafe.Mapper.CafeMapper;
import com.Poster.Cafe.Repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;

@Service
public class CafeService {

    private static final Logger LOGGER = LogManager.getLogger(CafeService.class);
    private final CafeRepository cafeRepository;
    private final CafeMapper cafeMapper;

    @Autowired
    public CafeService(CafeRepository cafeRepository, CafeMapper cafeMapper) {
        this.cafeRepository = cafeRepository;
        this.cafeMapper = cafeMapper;
    }

    //Получить данные о кафе
    public List<CafeDTO> getCafeData(){

        List<Cafe> cafes = cafeRepository.findAll();

        return cafes.stream()
                .map(cafe-> cafeMapper.toDTO(cafe))
                .collect(Collectors.toList());

    }

    //Изменить какие то данные о кафе
    public CafeDTO patchCafeById(CafeDTO cafeDTO){

        Cafe myCafe = cafeRepository.findById(1);
        String oldName = myCafe.getName();

        if(cafeDTO.getName() != null){

            myCafe.setName(cafeDTO.getName());
            LOGGER.info("Название кафе успешно обновлено с ", oldName, " на ", cafeDTO.getName());
            cafeRepository.save(myCafe);

        }

        return cafeMapper.toDTO(cafeRepository.findById(1));
    }

}
