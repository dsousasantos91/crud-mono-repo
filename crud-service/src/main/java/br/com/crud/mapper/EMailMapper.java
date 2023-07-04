package br.com.crud.mapper;

import br.com.crud.domain.EMail;
import br.com.crud.service.dto.EMailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EMailMapper {
    EMailDTO toDTO(EMail email);
    EMail toEMail(EMailDTO dto);
    List<EMailDTO> toDTOList(List<EMail> list);
}
