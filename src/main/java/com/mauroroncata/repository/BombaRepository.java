package com.mauroroncata.repository;

import com.mauroroncata.model.Bomba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BombaRepository extends JpaRepository<Bomba, Integer> {
    //Acesso ao banco para as bombas
}