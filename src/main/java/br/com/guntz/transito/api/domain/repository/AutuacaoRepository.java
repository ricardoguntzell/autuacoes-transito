package br.com.guntz.transito.api.domain.repository;

import br.com.guntz.transito.api.domain.model.Autuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutuacaoRepository extends JpaRepository<Autuacao, Long> {

}
