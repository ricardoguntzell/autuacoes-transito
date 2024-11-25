package br.com.guntz.transito.api.controller;

import br.com.guntz.transito.api.domain.model.Autuacao;
import br.com.guntz.transito.api.domain.repository.AutuacaoRepository;
import br.com.guntz.transito.api.domain.service.AutuacaoService;
import br.com.guntz.transito.api.model.input.AutuacaoInputModel;
import br.com.guntz.transito.api.model.output.AutuacaoModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {

    private AutuacaoRepository autuacaoRepository;
    private AutuacaoService autuacaoService;

    @GetMapping
    public List<AutuacaoModel> listarTodos(@PathVariable Long veiculoId) {
        return autuacaoRepository.findAll().stream()
                .map(AutuacaoModel::new)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoModel salvar(@RequestBody AutuacaoInputModel autuacaoInputModel) {
        Autuacao novaAutuacao = new Autuacao(autuacaoInputModel);

        return new AutuacaoModel(autuacaoService.salvar(novaAutuacao));
    }

}
