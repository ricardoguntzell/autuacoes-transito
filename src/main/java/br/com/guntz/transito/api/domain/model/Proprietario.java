package br.com.guntz.transito.api.domain.model;

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

    @Column(unique = true)
    private String email;

    private String telefone;

    public Proprietario(ProprietarioInputModel proprietarioInputModel){
        BeanUtils.copyProperties(proprietarioInputModel, this);
    }

}
