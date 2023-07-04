package br.com.crud.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private EnderecoDTO endereco;
    private List<TelefoneDTO> telefones;
    private List<EMailDTO> emails;
}
