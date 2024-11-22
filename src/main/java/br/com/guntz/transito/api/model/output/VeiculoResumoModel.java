package br.com.guntz.transito.api.model.output;

import br.com.guntz.transito.api.domain.model.SituacaoVeiculo;
import br.com.guntz.transito.api.domain.model.Veiculo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.OffsetDateTime;

@Getter
@Setter
public class VeiculoResumoModel {

    private Long id;

    private ProprietarioResumoModel proprietario;

    private String modelo;

    private String placa;

    private SituacaoVeiculo situacaoVeiculo;

    private OffsetDateTime dataApreensao;

    public VeiculoResumoModel(Veiculo veiculo) {
        BeanUtils.copyProperties(veiculo, this);
    }
}
