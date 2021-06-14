package git.com.dan.araujo.gestao.pessoas.api.entities;

import git.com.dan.araujo.gestao.pessoas.api.enums.TipoTelefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    @Column(name = "tipo", nullable = false)
    private TipoTelefone tipo;

    @Column(name = "numero", nullable = false)
    private String numero;
}
