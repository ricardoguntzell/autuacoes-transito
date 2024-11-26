package br.com.guntz.transito.api.domain.service;

import br.com.guntz.transito.api.domain.model.Autuacao;
import br.com.guntz.transito.api.domain.model.Veiculo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AutuacaoService {

    private VeiculoService veiculoService;

    @Transactional
    public Autuacao salvar(Long veiculoId, Autuacao novaAutuacao) {
        Veiculo veiculo = veiculoService.buscarVeiculoAutuacaoPorId(veiculoId);

        return veiculo.adicionarAutuacao(novaAutuacao);
    }

}
