package br.com.guntz.transito.api.domain.service;

import br.com.guntz.transito.api.domain.model.Autuacao;
import br.com.guntz.transito.api.domain.repository.AutuacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class AutuacaoService {

    private AutuacaoRepository autuacaoRepository;

    public Autuacao salvar(Autuacao novaAutuacao) {
        novaAutuacao.setDataOcorrencia(OffsetDateTime.now());

        return autuacaoRepository.save(novaAutuacao);
    }

}
