package git.com.dan.araujo.gestao.pessoas.api.utils;

import git.com.dan.araujo.gestao.pessoas.api.dto.request.DTOTelefone;
import git.com.dan.araujo.gestao.pessoas.api.entities.Telefone;
import git.com.dan.araujo.gestao.pessoas.api.enums.TipoDeTelefone;

public class TelefoneUtils {

    private static final String NUMERO_TELEFONE = "1199999-9999";
    private static final TipoDeTelefone TIPO_DE_TELEFONE = TipoDeTelefone.CELULAR;
    private static final long ID_TELEFONE = 1L;

    public static DTOTelefone criarDTOFake() {
        return DTOTelefone.builder()
                .numero(NUMERO_TELEFONE)
                .tipo(TIPO_DE_TELEFONE)
                .build();
    }

    public static Telefone criarEntidadeFake() {
        return Telefone.builder()
                .id(ID_TELEFONE)
                .numero(NUMERO_TELEFONE)
                .tipo(TIPO_DE_TELEFONE)
                .build();
    }
}
