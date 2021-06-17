package git.com.dan.araujo.gestao.pessoas.api.service;

import git.com.dan.araujo.gestao.pessoas.api.dto.request.DTOPessoa;
import git.com.dan.araujo.gestao.pessoas.api.dto.response.DTORespostaDaMensagem;
import git.com.dan.araujo.gestao.pessoas.api.entities.Pessoa;
import git.com.dan.araujo.gestao.pessoas.api.repository.RepositorioPessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static git.com.dan.araujo.gestao.pessoas.api.utils.PessoaUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServicePessoaTest {

    @Mock
    private RepositorioPessoa repositorioPessoa;

    @InjectMocks
    private ServicePessoa servicePessoa;

    @Test
    void testeDTOQueRetornaMensagemSalvaParaDeterminadaPessoa() {
        DTOPessoa dtoPessoa = criarDTOFake();
        Pessoa pessoaEsperadaSalva = criarEntidadeFake();

        when(repositorioPessoa.save(any(Pessoa.class))).thenReturn(pessoaEsperadaSalva);

        DTORespostaDaMensagem mensagemDeSucessoEsperada = criarRespostaEsperadaDaMensagem(pessoaEsperadaSalva.getId());
        DTORespostaDaMensagem mensagemDeSucesso = servicePessoa.criarPessoa(dtoPessoa);

        assertEquals(mensagemDeSucessoEsperada, mensagemDeSucesso);
    }

    private DTORespostaDaMensagem criarRespostaEsperadaDaMensagem(Long id) {
        return DTORespostaDaMensagem
                .builder()
                .mensagem("Pessoa criada com o ID " + id)
                .build();
    }

}
