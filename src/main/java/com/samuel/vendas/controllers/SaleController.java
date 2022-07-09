package com.samuel.vendas.controllers;

import com.samuel.vendas.dto.SaleDTO;
import com.samuel.vendas.dto.SaleSuccessDTO;
import com.samuel.vendas.dto.SaleSumDTO;
import com.samuel.vendas.services.SaleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
        Page<SaleDTO> sales = service.findAll(pageable);
        return ResponseEntity.ok(sales);
    }

    @GetMapping(value = "/sum-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
        List<SaleSumDTO> sales = service.amountGroupedBySeller();
        return ResponseEntity.ok(sales);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller(){
        List<SaleSuccessDTO> sales = service.successGroupedBySeller();
        return ResponseEntity.ok(sales);
    }
}
