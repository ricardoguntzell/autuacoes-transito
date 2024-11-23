package br.com.guntz.transito.api.model.output;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProprietarioIdModel {

    @NotNull
    private Long id;

}
