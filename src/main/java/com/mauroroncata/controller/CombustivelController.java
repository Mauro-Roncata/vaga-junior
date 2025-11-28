package com.mauroroncata.controller;

import com.mauroroncata.model.Combustivel;
import com.mauroroncata.repository.CombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Classe recebe requisições HTTP (GET, POST, etc)
@RequestMapping("/combustiveis") // O endereço base será: http://localhost:8080/combustiveis
public class CombustivelController {

    @Autowired // Injeta o repositório para podermos salvar/buscar dados
    private CombustivelRepository repository;

    // Rota para LISTAR todos (Verbo HTTP: GET)
    @GetMapping
    public List<Combustivel> listar() {
        return repository.findAll();
    }

    // Rota para CADASTRAR um novo (Verbo HTTP: POST)
    @PostMapping
    public Combustivel cadastrar(@RequestBody Combustivel combustivel) {
        // O @RequestBody pega o JSON e transforma na classe Combustivel
        return repository.save(combustivel);
    }

    // Rota para ATUALIZAR (Verbo HTTP: PUT)
    // Exemplo de URL: http://localhost:8080/combustiveis/1
    @PutMapping("/{id}")
    public Combustivel atualizar(@PathVariable Integer id, @RequestBody Combustivel combustivel) {
        // Garante que está atualizando o ID correto que veio na URL
        combustivel.setId(id);
        
       
        // Se tem ID, ele atualiza. Se não tem, ele cria.
        return repository.save(combustivel);
    }

    // Rota para DELETAR (Verbo HTTP: DELETE)
    // Exemplo de URL: http://localhost:8080/combustiveis/1
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
