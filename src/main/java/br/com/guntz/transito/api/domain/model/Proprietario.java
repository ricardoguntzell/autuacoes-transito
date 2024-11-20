package br.com.guntz.transito.api.domain.model;

import br.com.guntz.transito.api.model.input.ProprietarioInputModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private String email;

    private String telefone;

    public Proprietario(ProprietarioInputModel proprietarioInputModel){
        BeanUtils.copyProperties(proprietarioInputModel, this);
    }

}
