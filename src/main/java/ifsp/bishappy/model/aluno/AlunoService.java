package ifsp.bishappy.model.aluno;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	public Aluno getAlunoById(Long id) {
		return alunoRepository.getReferenceById(id);
	}
	
	public List<Aluno> listarAlunos() {
		return alunoRepository.findAll();
	}
	
	public Optional<Aluno> buscarAlunoPorNome(String nome) {
		//System.out.println("Procura = " + alunoRepository.findAllByNome(nome.trim()));
		return alunoRepository.findByNome(nome.trim());
				
	}
}
