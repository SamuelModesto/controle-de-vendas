package com.samuel.vendas.services;

import com.samuel.vendas.dto.SellerDTO;
import com.samuel.vendas.entities.Seller;
import com.samuel.vendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerDTO> findAll() {
        List<Seller> result = repository.findAll();
        return result.stream().map(e -> new SellerDTO(e)).collect(Collectors.toList());
    }
}
