package com.samuel.vendas.services;

import com.samuel.vendas.dto.SaleDTO;
import com.samuel.vendas.dto.SaleSuccessDTO;
import com.samuel.vendas.dto.SaleSumDTO;
import com.samuel.vendas.entities.Sale;
import com.samuel.vendas.repositories.SaleRepository;
import com.samuel.vendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){
        sellerRepository.findAll();//JPA ARMAZENA OS VENDEDORE NA CASH AUTOMÁTICAMENTE
        Page<Sale> sales = repository.findAll(pageable);
        return sales.map(e -> new SaleDTO(e));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller(){
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller(){
        return repository.successGroupedBySeller();
    }
}
