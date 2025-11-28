package com.mauroroncata.repository;

import com.mauroroncata.model.Combustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombustivelRepository extends JpaRepository<Combustivel, Integer> {
    // .save() -> Criar e Alterar
    // .findAll() -> Listar tudo
    // .findById() -> Buscar um
    // .deleteById() -> Deletar
    // Não precisa escrever nenhuma linha de SQL!
}
