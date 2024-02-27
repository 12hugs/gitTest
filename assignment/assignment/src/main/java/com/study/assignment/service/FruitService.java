package com.study.assignment.service;

import com.study.assignment.dto.request.FruitNotSoldMoreOrLessResponseDTO;
import com.study.assignment.dto.response.FruitStatResponseDTO;
import com.study.assignment.domain.entity.Fruit;
import com.study.assignment.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 읽기 전용
public class FruitService {

    private final FruitRepository fruitRepository;

    @Transactional
    public void fruitsave(FruitNotSoldMoreOrLessResponseDTO request){
        Fruit fruit = Fruit.builder()
                        .name(request.getName())
                        .warehousingDate(request.getWarehousingDate())
                        .price(request.getPrice())
                        .build();
        fruitRepository.save(fruit);
    }

    @Transactional
    public void fruitUpdate(Long id){
        Fruit fruit = fruitRepository.findById(id).orElse(null);
        if(fruit == null){
            throw new IllegalArgumentException();
        }
        fruit.setState("sold");
    }

    public Map<String, Object> fruitStat(String fruitName) {
        List<FruitStatResponseDTO> statFruit = fruitRepository.response(fruitName);

        Map<String, Object> result = new HashMap<>();

        result.put("salesAmount", statFruit.get(1).getPrice());
        result.put("notSalesAmount", statFruit.get(0).getPrice());

        return result;
    }

    public Long countFruit(String name) {
        return fruitRepository.countByName(name);
    }

    @Transactional
    public List<FruitNotSoldMoreOrLessResponseDTO> notSoldMoreOrLessList(String option, Integer price) {
        if(option.equals("GTE") || option.equals("gte")){
            List<Fruit> fruits = fruitRepository.findByPriceGreaterThan(price);
            List<FruitNotSoldMoreOrLessResponseDTO> response = new ArrayList<>();
            for(Fruit fruit : fruits){
                response.add(new FruitNotSoldMoreOrLessResponseDTO(fruit.getName(), fruit.getWarehousingDate(), fruit.getPrice()));
            }
            return response;
        }else if(option.equals("LTE") || option.equals("lte")) {
            List<Fruit> fruits = fruitRepository.findByPriceLessThan(price);
            List<FruitNotSoldMoreOrLessResponseDTO> response = new ArrayList<>();
            for(Fruit fruit : fruits){
                response.add(new FruitNotSoldMoreOrLessResponseDTO(fruit.getName(), fruit.getWarehousingDate(), fruit.getPrice()));
            }
            return response;
        }else{
            throw new IllegalArgumentException();
        }
    }
}
