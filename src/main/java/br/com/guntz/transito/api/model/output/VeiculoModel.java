package br.com.guntz.transito.api.model.output;

import br.com.guntz.transito.api.domain.model.Autuacao;
import br.com.guntz.transito.api.domain.model.Proprietario;
import br.com.guntz.transito.api.domain.model.SituacaoVeiculo;
import br.com.guntz.transito.api.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class VeiculoModel {

    private Long id;

    private ProprietarioVeiculoModel proprietario;

    private String marca;

    private String modelo;

    private String placa;

    private SituacaoVeiculo situacaoVeiculo;

    private OffsetDateTime dataApreensao;

    private List<AutuacaoModel> autuacoes = new ArrayList<>();

    public VeiculoModel(Veiculo veiculo, Proprietario proprietarioDomain, List<Autuacao> autuacoesDomain) {
        BeanUtils.copyProperties(veiculo, this);
        proprietario = new ProprietarioVeiculoModel(proprietarioDomain);

        setAutuacoes(autuacoesDomain.stream()
                .map(AutuacaoModel::new).
                toList());
    }
}
