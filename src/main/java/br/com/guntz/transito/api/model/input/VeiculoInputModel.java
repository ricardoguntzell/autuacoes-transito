package br.com.guntz.transito.api.model.input;

import br.com.guntz.transito.api.model.output.ProprietarioIdModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoInputModel {

    @Valid
    @NotNull
    private ProprietarioIdModel proprietario;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")
    private String placa;
}
