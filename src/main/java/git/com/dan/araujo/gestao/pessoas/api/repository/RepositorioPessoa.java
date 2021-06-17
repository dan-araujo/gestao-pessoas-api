package git.com.dan.araujo.gestao.pessoas.api.repository;

import git.com.dan.araujo.gestao.pessoas.api.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPessoa extends JpaRepository<Pessoa, Long> {
}
