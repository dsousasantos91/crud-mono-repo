package br.com.crud.service.dto;

import br.com.crud.domain.UF;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
    private Long id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private UF uf;
    private String complemento;
}
