package br.com.guntz.transito.api.domain.model;

import br.com.guntz.transito.api.model.input.AutuacaoInputModel;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tb_autuacao")
public class Autuacao {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    @ManyToOne
    private Veiculo veiculo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(columnDefinition = "DECIMAL(10, 2)")
    private BigDecimal valorMulta = new BigDecimal(BigInteger.ZERO);

    private OffsetDateTime dataOcorrencia;

    public Autuacao(AutuacaoInputModel autuacaoInputModel) {
        BeanUtils.copyProperties(autuacaoInputModel, this);
    }
}
