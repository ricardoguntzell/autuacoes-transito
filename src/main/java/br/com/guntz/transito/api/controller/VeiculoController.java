package br.com.guntz.transito.api.controller;

import br.com.guntz.transito.api.domain.repository.VeiculoRepository;
import br.com.guntz.transito.api.model.output.VeiculoResumoModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private VeiculoRepository veiculoRepository;

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
}
