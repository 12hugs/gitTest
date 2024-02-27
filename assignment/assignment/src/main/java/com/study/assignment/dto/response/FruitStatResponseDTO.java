package com.study.assignment.dto.response;

import lombok.Data;

@Data
public class FruitStatResponseDTO {
    private Long price;
    private String state;

    public FruitStatResponseDTO(String state, Long price) {
        this.price = price;
        this.state = state;
    }
}
