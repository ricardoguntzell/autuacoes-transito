package br.com.guntz.transito.api.domain.service;

import br.com.guntz.transito.api.domain.exception.NegocioException;
import br.com.guntz.transito.api.domain.exception.RecursoNaoEncontradoException;
import br.com.guntz.transito.api.domain.model.Proprietario;
import br.com.guntz.transito.api.domain.repository.ProprietarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProprietarioService {

    private ProprietarioRepository proprietarioRepository;

    @Transactional
    public Proprietario salvar(Proprietario proprietario) {
        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();

        if (emailEmUso){
            throw new NegocioException("Email já está em uso por outro proprietário");
        }

        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void ativar(Long proprietarioId) {
        Proprietario proprietario = buscarPorId(proprietarioId);
        proprietario.ativar();
    }

    @Transactional
    public void inativar(Long proprietarioId) {
        Proprietario proprietario = buscarPorId(proprietarioId);
        proprietario.inativar();
    }

    public Proprietario buscarPorId(Long proprietarioId) {
        return proprietarioRepository.findById(proprietarioId)
                .orElseThrow(RecursoNaoEncontradoException::new);
    }

    public Proprietario buscarProprietarioVeiculoPorId(Long proprietarioId) {
        return proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new NegocioException("Proprietário inexistente para esse Id"));
    }

}
