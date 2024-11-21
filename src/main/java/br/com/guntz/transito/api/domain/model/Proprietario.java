package br.com.guntz.transito.api.domain.model;

import br.com.guntz.transito.api.domain.exception.NegocioException;
import br.com.guntz.transito.api.model.input.ProprietarioInputModel;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
    private Situacao situacao = Situacao.ATIVO;

    public Proprietario(ProprietarioInputModel proprietarioInputModel) {
        BeanUtils.copyProperties(proprietarioInputModel, this);
    }

    public void ativar() {
        if (estaAtivo()) {
            throw new NegocioException("Proprietário já se encontra ativo");
        }

        setSituacao(Situacao.ATIVO);
    }

    public void inativar() {
        if (estaInativo()) {
            throw new NegocioException("Proprietário já se encontra inativo");
        }

        setSituacao(Situacao.INATIVO);
    }

    private boolean estaAtivo() {
        return getSituacao().equals(Situacao.ATIVO);
    }

    private boolean estaInativo() {
        return !estaAtivo();
    }
}
