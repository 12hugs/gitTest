package com.study.assignment.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FruitNotSoldMoreOrLessResponseDTO {
    private String name;
    private LocalDate warehousingDate;
    private Long price;
}
