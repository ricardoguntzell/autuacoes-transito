package br.com.guntz.transito.api.model.input;

import br.com.guntz.transito.api.domain.model.TipoMulta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AutuacaoInputModel {

    @NotBlank
    private String descricao;

    @NotNull
    private TipoMulta tipoMulta;

    @NotNull
    private BigDecimal valorMulta;
}
