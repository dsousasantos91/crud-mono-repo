package br.com.crud.service.dto;

import br.com.crud.domain.TipoTelefone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneDTO {
    private Long id;
    private Integer ddd;
    private String numero;
    private TipoTelefone tipo;
}
