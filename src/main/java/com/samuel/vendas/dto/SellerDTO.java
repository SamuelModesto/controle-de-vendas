package com.samuel.vendas.dto;

import com.samuel.vendas.entities.Seller;
import lombok.*;

import java.io.Serializable;

@Data
public class SellerDTO implements Serializable {
    private Long id;
    private String name;

    public SellerDTO(Seller seller){
        id = seller.getId();
        name = seller.getName();
    }
}
