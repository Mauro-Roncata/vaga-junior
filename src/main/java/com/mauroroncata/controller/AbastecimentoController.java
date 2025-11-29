package com.mauroroncata.controller;

import com.mauroroncata.model.Abastecimento;
import com.mauroroncata.repository.AbastecimentoRepository;
import com.mauroroncata.service.AbastecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService service;

    @Autowired
    private AbastecimentoRepository repository; 

    
    @GetMapping
    public List<Abastecimento> listar() {
        return repository.findAll();
    }

    
    @PostMapping
    public Abastecimento cadastrar(@RequestBody DadosAbastecimento dados) {
        // chamamos o service, que tem a inteligência de calcular os litros
        return service.registrar(dados.idBomba, dados.valorTotal);
    }


    
    @PutMapping("/{id}")
    public Abastecimento atualizar(@PathVariable Integer id, @RequestBody DadosAbastecimento dados) {
        return service.atualizar(id, dados.valorTotal);
    }

    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}

// Classe auxiliar apenas para receber os dados do JSON
class DadosAbastecimento {
    public Integer idBomba;
    public Double valorTotal;
}