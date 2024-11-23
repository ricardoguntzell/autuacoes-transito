package br.com.guntz.transito.api.domain.service;

import br.com.guntz.transito.api.domain.model.SituacaoVeiculo;
import br.com.guntz.transito.api.domain.model.Veiculo;
import br.com.guntz.transito.api.domain.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;

    @Transactional
    public Veiculo salvar(Veiculo veiculo) {
        veiculo.setSituacaoVeiculo(SituacaoVeiculo.REGULAR);
        veiculo.setDataCadastro(OffsetDateTime.now());

        return veiculoRepository.save(veiculo);
    }
}
