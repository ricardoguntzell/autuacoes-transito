package br.com.guntz.transito.api.domain.service;

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



        return proprietarioRepository.save(proprietario);
    }

}
