package br.com.guntz.transito.api.controller;

import br.com.guntz.transito.api.domain.model.Proprietario;
import br.com.guntz.transito.api.domain.model.Veiculo;
import br.com.guntz.transito.api.domain.repository.ProprietarioRepository;
import br.com.guntz.transito.api.domain.repository.VeiculoRepository;
import br.com.guntz.transito.api.domain.service.ProprietarioService;
import br.com.guntz.transito.api.domain.service.VeiculoService;
import br.com.guntz.transito.api.model.input.VeiculoInputModel;
import br.com.guntz.transito.api.model.output.VeiculoResumoModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private VeiculoRepository veiculoRepository;
    private ProprietarioService proprietarioService;
    private VeiculoService veiculoService;

    @GetMapping
    public List<VeiculoResumoModel> listarTodos() {
        return veiculoRepository.findAll().stream()
                .map(v -> (new VeiculoResumoModel(v, v.getProprietario())))
                .toList();
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoResumoModel> buscarPorId(@PathVariable Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .map(v -> (new VeiculoResumoModel(v, v.getProprietario())))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoResumoModel salvar(@Valid @RequestBody VeiculoInputModel veiculoInputModel) {
        Proprietario proprietario = proprietarioService
                .buscarProprietarioVeiculoPorId(veiculoInputModel.getProprietario().getId());

        Veiculo novoVeiculo = new Veiculo(veiculoInputModel);
        Veiculo veiculoSalvo = veiculoService.salvar(novoVeiculo);

        return new VeiculoResumoModel(veiculoSalvo, proprietario);
    }
}
