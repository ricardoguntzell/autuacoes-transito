package br.com.guntz.transito.api.controller;

import br.com.guntz.transito.api.domain.model.Proprietario;
import br.com.guntz.transito.api.domain.repository.ProprietarioRepository;
import br.com.guntz.transito.api.domain.service.ProprietarioService;
import br.com.guntz.transito.api.model.input.ProprietarioInputModel;
import br.com.guntz.transito.api.model.output.ProprietarioResumoModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ProprietarioResumoModel salvar(@Valid @RequestBody ProprietarioInputModel proprietarioInputModel) {
        Proprietario proprietario = new Proprietario(proprietarioInputModel);

        return new ProprietarioResumoModel(proprietarioService.salvar(proprietario));
    }

    @PutMapping("/{proprietarioId}")
    public ProprietarioResumoModel atualizar(@PathVariable Long proprietarioId,
                                             @Valid @RequestBody ProprietarioInputModel proprietarioInputModel) {
        proprietarioService.buscarPorId(proprietarioId);
        Proprietario proprietarioAtualizado = new Proprietario(proprietarioInputModel);
        proprietarioAtualizado.setId(proprietarioId);

        return new ProprietarioResumoModel(proprietarioService.salvar(proprietarioAtualizado));
    }

    @PutMapping("/{proprietarioId}/ativar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void ativar(@PathVariable Long proprietarioId){
        proprietarioService.ativar(proprietarioId);
    }

    @DeleteMapping("/{proprietarioId}/ativar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@PathVariable Long proprietarioId){
        proprietarioService.inativar(proprietarioId);
    }
}
