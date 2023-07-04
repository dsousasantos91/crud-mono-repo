package br.com.crud.mapper;

import br.com.crud.domain.Telefone;
import br.com.crud.service.dto.TelefoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TelefoneMapper {
    TelefoneDTO toDTO(Telefone telefone);
    Telefone toTelefone(TelefoneDTO dto);
    List<TelefoneDTO> toDTOList(List<Telefone> list);
}
