package com.mucheniski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mucheniski.domains.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
