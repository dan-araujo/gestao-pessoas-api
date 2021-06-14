package git.com.dan.araujo.gestao.pessoas.api.controller;

import git.com.dan.araujo.gestao.pessoas.api.dto.request.PessoaDTO;
import git.com.dan.araujo.gestao.pessoas.api.dto.response.MensagemResponseDTO;
import git.com.dan.araujo.gestao.pessoas.api.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/pessoa")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {

    private PessoaService pessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemResponseDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
       return pessoaService.criarPessoa(pessoaDTO);
    }

}
