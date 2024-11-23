package br.com.guntz.transito.api.domain.model;

import br.com.guntz.transito.api.domain.exception.NegocioException;
import br.com.guntz.transito.api.model.output.ProprietarioIdModel;
import br.com.guntz.transito.api.model.input.ProprietarioInputModel;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tb_proprietario")
public class Proprietario {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, length = 150)
    private String email;

    @Column(length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private SituacaoProprietario situacao = SituacaoProprietario.ATIVO;

    public Proprietario(ProprietarioInputModel proprietarioInputModel) {
        BeanUtils.copyProperties(proprietarioInputModel, this);
    }

    public Proprietario(ProprietarioIdModel proprietarioId) {
        BeanUtils.copyProperties(proprietarioId, this);
    }

    public void ativar() {
        if (estaAtivo()) {
            throw new NegocioException("Proprietário já se encontra ativo");
        }

        setSituacao(SituacaoProprietario.ATIVO);
    }

    public void inativar() {
        if (estaInativo()) {
            throw new NegocioException("Proprietário já se encontra inativo");
        }

        setSituacao(SituacaoProprietario.INATIVO);
    }

    private boolean estaAtivo() {
        return getSituacao().equals(SituacaoProprietario.ATIVO);
    }

    private boolean estaInativo() {
        return !estaAtivo();
    }
}
