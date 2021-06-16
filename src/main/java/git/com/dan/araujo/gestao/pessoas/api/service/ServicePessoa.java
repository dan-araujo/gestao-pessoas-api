package git.com.dan.araujo.gestao.pessoas.api.service;

import git.com.dan.araujo.gestao.pessoas.api.dto.request.DTOPessoa;
import git.com.dan.araujo.gestao.pessoas.api.dto.response.DTORespostaDaMensagem;
import git.com.dan.araujo.gestao.pessoas.api.entities.Pessoa;
import git.com.dan.araujo.gestao.pessoas.api.exception.PessoaNaoEncontradaException;
import git.com.dan.araujo.gestao.pessoas.api.mapper.MapperPessoa;
import git.com.dan.araujo.gestao.pessoas.api.repository.RepositorioPessoa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServicePessoa {

    private final RepositorioPessoa repositorioPessoa;

    private final MapperPessoa mapperPessoa = MapperPessoa.INSTANCE;

    public DTORespostaDaMensagem criarPessoa(DTOPessoa pessoaDTO) {
        Pessoa salvarPessoa = mapperPessoa.toModel(pessoaDTO);

        Pessoa pessoaSalva = repositorioPessoa.save(salvarPessoa);
        return criarRespostaDaMensagem(pessoaSalva.getId(), "Pessoa criada com o ID");
    }

    public List<DTOPessoa> listarTodos() {
        List<Pessoa> todasAsPessoas = repositorioPessoa.findAll();
        return todasAsPessoas.stream()
                .map(mapperPessoa::toDTO)
                .collect(Collectors.toList());
    }

    public DTOPessoa encontrarPorId(Long id) throws PessoaNaoEncontradaException {
        Pessoa pessoa = verificarSeExiste(id);

        return mapperPessoa.toDTO(pessoa);
    }

    public void deletar(Long id) throws PessoaNaoEncontradaException {
        verificarSeExiste(id);
        repositorioPessoa.deleteById(id);
    }

    public DTORespostaDaMensagem atualizarPorId(Long id, DTOPessoa dtoPessoa) throws PessoaNaoEncontradaException {
        verificarSeExiste(id);

        Pessoa atualizarPessoa = mapperPessoa.toModel(dtoPessoa);

        Pessoa pessoaAtualizada = repositorioPessoa.save(atualizarPessoa);
        return criarRespostaDaMensagem(pessoaAtualizada.getId(), "Pessoa atualizada com o ID ");
    }

    private Pessoa verificarSeExiste(Long id) throws PessoaNaoEncontradaException {
        return repositorioPessoa.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
    }

    private DTORespostaDaMensagem criarRespostaDaMensagem(Long id, String mensagem) {
        return DTORespostaDaMensagem
                .builder()
                .mensagem(mensagem + id)
                .build();
    }


}
