package com.mauroroncata.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHora; // Data exata do abastecimento
    private Double valorTotal;      // Quanto o cliente pagou 
    private Double litros;          // Quanto entrou no tanque 

    @ManyToOne // Vários abastecimentos acontecem em uma Bomba
    @JoinColumn(name = "bomba_id")
    private Bomba bomba;

    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public Double getLitros() { return litros; }
    public void setLitros(Double litros) { this.litros = litros; }

    public Bomba getBomba() { return bomba; }
    public void setBomba(Bomba bomba) { this.bomba = bomba; }
}