package br.com.guntz.transito.api.controller;

import br.com.guntz.transito.api.domain.model.Autuacao;
import br.com.guntz.transito.api.domain.model.Veiculo;
import br.com.guntz.transito.api.domain.repository.AutuacaoRepository;
import br.com.guntz.transito.api.domain.service.AutuacaoService;
import br.com.guntz.transito.api.domain.service.VeiculoService;
import br.com.guntz.transito.api.model.input.AutuacaoInputModel;
import br.com.guntz.transito.api.model.output.AutuacaoModel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "bearer-key")
@AllArgsConstructor
@RestController
@RequestMapping("/api/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {

    private VeiculoService veiculoService;
    private AutuacaoService autuacaoService;

    @GetMapping
    public List<AutuacaoModel> listarTodos(@PathVariable Long veiculoId) {
        Veiculo veiculo = veiculoService.buscarVeiculoAutuacaoPorId(veiculoId);

        return veiculo.getAutuacoes().stream()
                .map(AutuacaoModel::new)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoModel salvar(@PathVariable Long veiculoId, @Valid @RequestBody AutuacaoInputModel autuacaoInputModel) {
        Autuacao novaAutuacao = new Autuacao(autuacaoInputModel);

        return new AutuacaoModel(autuacaoService.salvar(veiculoId, novaAutuacao));
    }

}
