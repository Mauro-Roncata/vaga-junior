package com.mauroroncata.controller;

import com.mauroroncata.model.Bomba;
import com.mauroroncata.repository.BombaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bombas")
public class BombaController {

    @Autowired
    private BombaRepository repository;

    @GetMapping
    public List<Bomba> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Bomba cadastrar(@RequestBody Bomba bomba) {
        // transformar o ID do combustível em uma entidade Combustivel
        return repository.save(bomba);
    }
    
    @PutMapping("/{id}") 
    public Bomba atualizar(@PathVariable Integer id, @RequestBody Bomba bomba){
        bomba.setId(id);;

        return repository.save(bomba);
    }

    @DeleteMapping("/{id}")
    public void deletar (@PathVariable Integer id) {
        repository.deleteById(id);
    }

    

}