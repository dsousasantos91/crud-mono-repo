package br.com.crud.mapper;

import br.com.crud.domain.Cliente;
import br.com.crud.service.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente cliente);
    Cliente toCliente(ClienteDTO dto);
}
