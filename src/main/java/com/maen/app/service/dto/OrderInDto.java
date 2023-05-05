package com.maen.app.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderInDto {

    private String product;
    private Double price;
    private Integer customerId;
}
