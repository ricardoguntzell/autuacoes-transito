package br.com.guntz.transito.api.model.output;

import br.com.guntz.transito.api.domain.model.Proprietario;
import br.com.guntz.transito.api.domain.model.SituacaoVeiculo;
import br.com.guntz.transito.api.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
@Setter
public class VeiculoResumoModel {

    private Long id;

    private ProprietarioVeiculoModel proprietario;

    private String marca;

    private String modelo;

    private String placa;

    private SituacaoVeiculo situacaoVeiculo;

    private OffsetDateTime dataApreensao;

    public VeiculoResumoModel(Veiculo veiculo, Proprietario proprietarioDomain) {
        BeanUtils.copyProperties(veiculo, this);
        proprietario = new ProprietarioVeiculoModel(proprietarioDomain);
    }
}
