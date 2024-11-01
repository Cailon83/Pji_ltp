package ifsp.bishappy.model.aluno;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	Optional <Aluno> findByNome(String nomeAluno);



}
