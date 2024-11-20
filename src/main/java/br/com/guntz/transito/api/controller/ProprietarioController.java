package br.com.guntz.transito.api.controller;

import br.com.guntz.transito.api.domain.model.Proprietario;
import br.com.guntz.transito.api.domain.repository.ProprietarioRepository;
import br.com.guntz.transito.api.domain.service.ProprietarioService;
import br.com.guntz.transito.api.model.input.ProprietarioInputModel;
import br.com.guntz.transito.api.model.output.ProprietarioResumoModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/proprietarios")
public class ProprietarioController {

    private ProprietarioRepository proprietarioRepository;
    private ProprietarioService proprietarioService;

    @GetMapping
    public List<ProprietarioResumoModel> listarTodos() {
        return proprietarioRepository.findAll().stream()
                .map(ProprietarioResumoModel::new)
                .toList();
    }

    @GetMapping("/{proprietarioId}")
    public ResponseEntity<Proprietario> buscarPorId(@PathVariable Long proprietarioId) {
        return proprietarioRepository.findById(proprietarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProprietarioResumoModel salvar(@RequestBody ProprietarioInputModel proprietarioInputModel) {
        Proprietario proprietario = new Proprietario(proprietarioInputModel);

        return new ProprietarioResumoModel(proprietarioService.salvar(proprietario));
    }


}
