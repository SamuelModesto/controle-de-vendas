package com.samuel.vendas.dto;

import com.samuel.vendas.entities.Seller;
import lombok.*;

import java.io.Serializable;

@Data
public class SaleSumDTO implements Serializable {

    private String sellerName;
    private Double sum;

    public SaleSumDTO(Seller seller, Double sum) {
        this.sellerName = seller.getName();
        this.sum = sum;
    }
}
