package git.com.dan.araujo.gestao.pessoas.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDeTelefone {

    RESIDENCIAL("Residencial"),
    CELULAR("Celular"),
    COMERCIAL("Comercial");

    private final String descricao;
}
