package com.study.assignment.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
public class FruitNotSoldMoreOrLessResponseDTO {
    private String name;
    private LocalDate warehousingDate;
    private Long price;

}
