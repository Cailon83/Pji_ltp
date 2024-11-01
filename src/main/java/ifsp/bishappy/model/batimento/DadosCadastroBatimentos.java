package ifsp.bishappy.model.batimento;

import java.time.LocalDateTime;

public record DadosCadastroBatimentos(
		int bpm,
		LocalDateTime dataBatimento, 
		Long alunoId) {

}
