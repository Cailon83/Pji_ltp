package ifsp.bishappy.model.aluno;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record DadosAtualizaAluno(
		@NotNull
		long id,
		@NotBlank
		String nome, 
		@NotBlank
		String etnia,
		@Past
		LocalDate dataNascimento,
		@NotBlank
		String cidade, 
		@NotBlank @Email
		String email,
		@NotBlank
		String contatoEmergencia, 
		@NotBlank
		String curso) {

}
