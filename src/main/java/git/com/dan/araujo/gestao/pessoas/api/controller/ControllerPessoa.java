package git.com.dan.araujo.gestao.pessoas.api.controller;

import git.com.dan.araujo.gestao.pessoas.api.dto.request.DTOPessoa;
import git.com.dan.araujo.gestao.pessoas.api.dto.response.DTORespostaDaMensagem;
import git.com.dan.araujo.gestao.pessoas.api.exception.PessoaNaoEncontradaException;
import git.com.dan.araujo.gestao.pessoas.api.service.ServicePessoa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ControllerPessoa {

    private final ServicePessoa servicePessoa;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DTORespostaDaMensagem criarPessoa(@RequestBody @Valid DTOPessoa dtoPessoa) {
        return servicePessoa.criarPessoa(dtoPessoa);
    }

    @GetMapping
    public List<DTOPessoa> listarTodos() {
        return servicePessoa.listarTodos();
    }

    @GetMapping("/{id}")
    public DTOPessoa encontrarPorId(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return servicePessoa.encontrarPorId(id);
    }

    @PutMapping("/{id}")
    public DTORespostaDaMensagem atualizarPorId(@PathVariable Long id, @RequestBody @Valid DTOPessoa dtoPessoa) throws PessoaNaoEncontradaException {
        return servicePessoa.atualizarPorId(id, dtoPessoa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id) throws PessoaNaoEncontradaException {
        servicePessoa.deletar(id);
    }

}
