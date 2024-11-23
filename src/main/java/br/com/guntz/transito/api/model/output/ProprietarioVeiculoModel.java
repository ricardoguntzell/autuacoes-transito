package br.com.guntz.transito.api.model.output;

import br.com.guntz.transito.api.domain.model.Proprietario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@AllArgsConstructor
public class ProprietarioVeiculoModel {

    private String nome;

    private String email;

    public ProprietarioVeiculoModel(Proprietario proprietario){
        BeanUtils.copyProperties(proprietario, this);
    }
}
