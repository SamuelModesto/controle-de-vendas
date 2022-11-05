package com.samuel.vendas.repositories;

import com.samuel.vendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Optional<Seller> findByName(String name);
}
