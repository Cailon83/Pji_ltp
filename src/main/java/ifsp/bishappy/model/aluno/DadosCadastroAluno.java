package ifsp.bishappy.model.aluno;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public record DadosCadastroAluno( 
		@NotBlank (message = "Nome é obrigatório")
		String nome,
		@NotBlank (message = "Etnia é obrigatório")
		String etnia,
		@Past (message = "Data Nascimento deve ser menor que data atual")
		LocalDate dataNascimento,
		@NotBlank (message = "Cidade é obrigatória")
		String cidade, 
		@NotBlank @Email 
		String email,
		@NotBlank (message = "Contato Emerência é obrigatória")
		String contatoEmergencia, 
		@NotBlank
		String curso ) {

}
