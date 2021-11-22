package com.samuel.vendas.repositories;

import com.samuel.vendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
