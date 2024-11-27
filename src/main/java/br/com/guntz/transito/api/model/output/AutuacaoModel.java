package br.com.guntz.transito.api.model.output;

import br.com.guntz.transito.api.domain.model.Autuacao;
import br.com.guntz.transito.api.domain.model.TipoMulta;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class AutuacaoModel {

    private Long id;

    private String descricao;

    private BigDecimal valorMulta;

    private TipoMulta tipoMulta;

    private OffsetDateTime dataOcorrencia;

    public AutuacaoModel(Autuacao autuacao) {
        BeanUtils.copyProperties(autuacao, this);
    }

}
