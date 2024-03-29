package com.samuel.vendas.controllers;

import com.samuel.vendas.dto.SellerDTO;
import com.samuel.vendas.entities.Seller;
import com.samuel.vendas.repositories.SellerRepository;
import com.samuel.vendas.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private SellerRepository sellerRepository;

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll() {
        List<SellerDTO> list = sellerService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> findById(@PathVariable Long id) {
        return sellerRepository.findById(id)
                .map(seller -> ResponseEntity.ok(seller))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Seller save(@Valid @RequestBody Seller seller) {
        return sellerService.salvar(seller);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Seller> update(@PathVariable Long id, @RequestBody Seller seller) {
        if (!sellerRepository.existsById(id)) {
            ResponseEntity.notFound().build();
        }
        seller.setId(id);
        seller = sellerRepository.save(seller);
        return ResponseEntity.ok(seller);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (!sellerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sellerService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
