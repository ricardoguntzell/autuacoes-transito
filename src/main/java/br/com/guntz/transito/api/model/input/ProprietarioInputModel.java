package br.com.guntz.transito.api.model.input;

import br.com.guntz.transito.api.domain.model.Proprietario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@Getter
@Setter
public class ProprietarioInputModel {

    private String nome;

    private String email;

    private String telefone;

    public ProprietarioInputModel(Proprietario proprietario){
        BeanUtils.copyProperties(proprietario,this);
    }

}
