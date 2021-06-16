package git.com.dan.araujo.gestao.pessoas.api.dto.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DTORespostaDaMensagem {
    private String mensagem;
}
