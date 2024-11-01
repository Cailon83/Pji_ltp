package ifsp.bishappy.model.aluno;

import java.time.LocalDate;

public record DadosListagemAluno( 
		long id,
		String nome, 
		String etnia,
		LocalDate dataNascimento,
		int idade,
		String cidade, 
		String email, 
		String contatoEmergencia, 
		String curso ) {
	
	public DadosListagemAluno (Aluno aluno) {
		this(aluno.getId(), aluno.getNome(), aluno.getEtnia(),
				aluno.getDataNascimento(),
				aluno.getIdade(),
				aluno.getCidade(),
				aluno.getEmail(), aluno.getContatoEmergencia(),
				aluno.getCurso());
	}

}
