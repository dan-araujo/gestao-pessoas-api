package git.com.dan.araujo.gestao.pessoas.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DTOPessoa {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String primeiroNome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String sobrenome;

    @NotEmpty
    @CPF
    private String cpf;

    private String dataNascimento;

    @Valid
    @NotEmpty
    private List<DTOTelefone> telefones;

}
