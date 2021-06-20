package one.digitalinnovation.agendapi.dto.mapper;

import one.digitalinnovation.agendapi.dto.request.PessoaDTO;
import one.digitalinnovation.agendapi.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO dto);

    PessoaDTO toDTO(Pessoa dto);
}
