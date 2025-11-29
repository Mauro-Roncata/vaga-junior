package com.mauroroncata.service;

import com.mauroroncata.model.Abastecimento;
import com.mauroroncata.model.Bomba;
import com.mauroroncata.repository.AbastecimentoRepository;
import com.mauroroncata.repository.BombaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service // Diz ao Spring: "Aqui tem regras de negócio"
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private BombaRepository bombaRepository;

    public Abastecimento registrar(Integer idBomba, Double valorTotal) {
        // Busca a bomba no banco de dados
        Bomba bomba = bombaRepository.findById(idBomba).orElseThrow();

        // Descobre o preço do combustível daquela bomba
        Double preco = bomba.getCombustivel().getPrecoPorLitro();

        // Calcula os litros (Regra de Negócio)
        Double litros = valorTotal / preco;

        // Monta o objeto Abastecimento para salvar
        Abastecimento novoAbastecimento = new Abastecimento();
        novoAbastecimento.setBomba(bomba);
        novoAbastecimento.setValorTotal(valorTotal);
        novoAbastecimento.setLitros(litros); // Valor calculado
        novoAbastecimento.setDataHora(LocalDateTime.now()); // Data de agora

        // Salva no banco
        return abastecimentoRepository.save(novoAbastecimento);
    }
}