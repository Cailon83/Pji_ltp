package ifsp.bishappy.model.batimento;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ifsp.bishappy.model.aluno.Aluno;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "batimentos")
@Entity (name = "Batimentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Batimentos {
	
	@Column (name="batimento_id")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime dataBatimento; 
	private int bpm;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "aluno_id", referencedColumnName = "aluno_id")
	private Aluno aluno;
	
	public Batimentos(DadosCadastroBatimentos dados, Aluno aluno) {
		this.dataBatimento = dados.dataBatimento();
		this.bpm = dados.bpm();
		this.aluno = aluno;
	}

	public void atualizarInformacoes(@Valid DadosAtualizaBatimentos dados) {
		if (dados.bpm() != 0) 
			this.bpm = dados.bpm();
	}
}
