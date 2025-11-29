package com.mauroroncata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Transforma classe em tabela no banco de dados
public class Combustivel {

    @Id // Diz que este campo é a Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Diz pro banco gerar o ID sozinho 
    private int id;

    private String nome; 
    private Double precoPorLitro;

    // Getters e Setters 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoPorLitro() {
        return precoPorLitro;
    }

    public void setPrecoPorLitro(Double precoPorLitro) {
        this.precoPorLitro = precoPorLitro;
    }
}