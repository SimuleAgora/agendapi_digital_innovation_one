package one.digitalinnovation.agendapi.repositories;

import one.digitalinnovation.agendapi.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
