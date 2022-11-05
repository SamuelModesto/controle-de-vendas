package com.samuel.vendas.services;

import com.samuel.vendas.dto.SellerDTO;
import com.samuel.vendas.entities.Seller;
import com.samuel.vendas.exception.NegocioException;
import com.samuel.vendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.TransactionScoped;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional
    public Seller salvar(Seller seller) {
        boolean existsEmail = sellerRepository.findByName(seller.getName())
                .stream()
                .anyMatch(sellerExists -> !sellerExists.equals(seller));

        if(existsEmail){
            throw new NegocioException("Já existe um cliente cadastrado com esse nome.");
        }
        return sellerRepository.save(seller);
    }

    @Transactional
    public void excluir(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }

    public List<SellerDTO> findAll() {
        List<Seller> result = sellerRepository.findAll();
        return result.stream().map(e -> new SellerDTO(e)).collect(Collectors.toList());
    }
}
