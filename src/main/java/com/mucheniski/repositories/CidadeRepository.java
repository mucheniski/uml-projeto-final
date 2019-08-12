package com.mucheniski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mucheniski.domains.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
