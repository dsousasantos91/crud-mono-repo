package br.com.crud.mapper;

import br.com.crud.domain.Endereco;
import br.com.crud.service.dto.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EnderecoMapper {
    EnderecoDTO toDTO(Endereco endereco);
    Endereco toEndereco(EnderecoDTO dto);
}
