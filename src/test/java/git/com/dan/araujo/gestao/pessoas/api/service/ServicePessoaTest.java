package git.com.dan.araujo.gestao.pessoas.api.service;

import git.com.dan.araujo.gestao.pessoas.api.dto.request.DTOPessoa;
import git.com.dan.araujo.gestao.pessoas.api.repository.RepositorioPessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private RepositorioPessoa repositorioPessoa;

    @InjectMocks
    private ServicePessoa servicePessoa;

    @Test
    void testeDTOParaRetornarMensagemSalvaParaDeterminadaPessoa() {
        DTOPessoa dtoPessoa = criarDTOFake();
    }

}
