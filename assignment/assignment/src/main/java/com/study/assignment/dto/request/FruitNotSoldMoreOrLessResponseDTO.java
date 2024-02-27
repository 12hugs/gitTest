package com.study.assignment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class FruitNotSoldMoreOrLessResponseDTO {
    private String name;
    private LocalDate warehousingDate;
    private Long price;

    public FruitNotSoldMoreOrLessResponseDTO(String name, LocalDate warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }
}
