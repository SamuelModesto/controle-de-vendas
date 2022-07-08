package com.samuel.vendas.dto;

import com.samuel.vendas.entities.Seller;
import lombok.*;

import java.io.Serializable;

@Data
public class SaleSuccessDTO implements Serializable {

    private String sellerName;
    private Long visited;
    private Long deals;

    public SaleSuccessDTO(Seller seller, Long visited, Long deals){
        sellerName = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }
}

