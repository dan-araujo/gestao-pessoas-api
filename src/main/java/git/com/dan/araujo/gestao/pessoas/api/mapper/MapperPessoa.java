package git.com.dan.araujo.gestao.pessoas.api.mapper;

import git.com.dan.araujo.gestao.pessoas.api.dto.request.DTOPessoa;
import git.com.dan.araujo.gestao.pessoas.api.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperPessoa {

    MapperPessoa INSTANCE = Mappers.getMapper(MapperPessoa.class);

    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(DTOPessoa dtoPessoa);

    DTOPessoa toDTO(Pessoa pessoa);
}
