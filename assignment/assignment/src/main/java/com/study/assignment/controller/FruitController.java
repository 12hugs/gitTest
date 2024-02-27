package com.study.assignment.controller;

import com.study.assignment.domain.entity.Fruit;
import com.study.assignment.dto.request.FruitNotSoldMoreOrLessResponseDTO;
import com.study.assignment.dto.request.FruitUpdateRequestDTO;
import com.study.assignment.service.FruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi")
public class FruitController {

    private final FruitService fruitService;

    @PostMapping("/fruit")
    public void postFruit(@RequestBody FruitNotSoldMoreOrLessResponseDTO request){
        fruitService.fruitsave(request);
    }

    @PutMapping("/fruit")
    public void putFruit(@RequestBody FruitUpdateRequestDTO request){
        fruitService.fruitUpdate(request.getId());
    }

    @GetMapping("/fruit/stat")
    public Map<String, Object> statFruit(@RequestParam("name") String fruitName){
        return fruitService.fruitStat(fruitName);
    }

    @GetMapping("/fruit/count")
    public Long countFruit(@RequestParam("name") String name){
        return fruitService.countFruit(name);
    }


    @GetMapping("/fruit/list")
    public List<Fruit> notSoldMoreOrLessList(@RequestParam("option")String option,
                                             @RequestParam("price")Integer price){
        return fruitService.notSoldMoreOrLessList(option, price);
    }
}
