package br.com.guntz.transito.api.controller;

import br.com.guntz.transito.api.domain.repository.ProprietarioRepository;
import br.com.guntz.transito.api.model.output.ProprietarioResumoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @GetMapping
    public List<ProprietarioResumoModel> listarTodos() {
        return proprietarioRepository.findAll().stream()
                .map(ProprietarioResumoModel::new)
                .toList();
    }

    @GetMapping("/{proprietarioId}")
    public ResponseEntity<ProprietarioResumoModel> buscarPorId(@PathVariable Long proprietarioId) {
        return proprietarioRepository.findById(proprietarioId)
                .map(ProprietarioResumoModel::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
