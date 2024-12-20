package br.com.guntz.transito.api.model.output;

import br.com.guntz.transito.api.domain.model.Proprietario;
import br.com.guntz.transito.api.domain.model.SituacaoProprietario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@Getter
@Setter
public class ProprietarioResumoModel {

    private Long id;

    private String nome;

    private SituacaoProprietario situacao;

    public ProprietarioResumoModel(Proprietario proprietario) {
        BeanUtils.copyProperties(proprietario, this);
    }
}
