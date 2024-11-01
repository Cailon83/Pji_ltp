package ifsp.bishappy.model.aluno;

import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="aluno")
@Entity(name="Aluno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

	@Column (name="aluno_id")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String etnia;
	private LocalDate dataNascimento;
	private String cidade;
	private String email;
	private String contatoEmergencia;
	
	@Transient
	private int idade;
	
	public int getIdade () {
		final LocalDate hoje =  LocalDate.now();
		Period idade = Period.between(this.dataNascimento, hoje);
		return  idade.getYears() ;
	}
	
//	@Enumerated(EnumType.STRING)
	private String curso;
	
	public Aluno(DadosCadastroAluno dados) {
		this.nome = dados.nome();
		this.etnia = dados.etnia();
		this.dataNascimento = dados.dataNascimento();
		this.curso = dados.curso();
		this.cidade = dados.cidade();
		this.email = dados.email();
		this.contatoEmergencia = dados.contatoEmergencia();
	}

	public void atualizarInformacoes(@Valid DadosAtualizaAluno dados) {
		if (dados.nome() != null)
			this.nome = dados.nome();
		if (dados.etnia() != null)
			this.etnia = dados.etnia();
		if (dados.dataNascimento()!= null)
			this.dataNascimento = dados.dataNascimento();
		if (dados.curso() != null)
			this.curso = dados.curso();
		if (dados.cidade() != null)
			this.cidade = dados.cidade();
		if (dados.email() != null)
			this.email = dados.email();
		if (dados.contatoEmergencia() != null)
			this.contatoEmergencia = dados.contatoEmergencia();
	}

}
