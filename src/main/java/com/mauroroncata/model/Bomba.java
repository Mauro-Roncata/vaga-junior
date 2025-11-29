package com.mauroroncata.model;

import jakarta.persistence.*;

@Entity
public class Bomba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome; 

    @ManyToOne // Várias bombas -> Um Combustível
    @JoinColumn(name = "combustivel_id") // Cria a coluna 'combustivel_id' no banco (chave estrangeira)
    private Combustivel combustivel;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }
}