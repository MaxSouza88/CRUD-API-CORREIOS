package com.example.CRUD.Consumo.API.CORREIOS.repository;

import com.example.CRUD.Consumo.API.CORREIOS.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}