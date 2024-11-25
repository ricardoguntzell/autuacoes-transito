package br.com.guntz.transito.api.model.input;

import br.com.guntz.transito.api.model.output.VeiculoIdModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AutuacaoInputModel {

    private VeiculoIdModel veiculo;

    private String descricao;

    private BigDecimal valorMulta;
}
