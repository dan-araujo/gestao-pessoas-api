package git.com.dan.araujo.gestao.pessoas.api.utils;

import git.com.dan.araujo.gestao.pessoas.api.dto.request.DTOPessoa;
import git.com.dan.araujo.gestao.pessoas.api.entities.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final String PRIMEIRO_NOME = "Danilo";
    private static final String SOBRENOME = "Araújo";
    private static final String NUMERO_CPF = "643.404.570-00";
    private static final long ID_PESSOA = 1L;
    public static final LocalDate DATA_NASCIMENTO = LocalDate.of(1997, 11, 1);

    public static DTOPessoa criarDTOFake() {
        return DTOPessoa.builder()
                .primeiroNome(PRIMEIRO_NOME)
                .sobrenome(SOBRENOME)
                .cpf(NUMERO_CPF)
                .dataNascimento("04-04-1997")
                .telefones(Collections.singletonList(TelefoneUtils.criarDTOFake()))
                .build();
    }

    public static Pessoa criarEntidadeFake() {
        return Pessoa.builder()
                .id(ID_PESSOA)
                .primeiroNome(PRIMEIRO_NOME)
                .sobrenome(SOBRENOME)
                .cpf(NUMERO_CPF)
                .dataNascimento(DATA_NASCIMENTO)
                .telefones(Collections.singletonList(TelefoneUtils.criarEntidadeFake()))
                .build();
    }

}
