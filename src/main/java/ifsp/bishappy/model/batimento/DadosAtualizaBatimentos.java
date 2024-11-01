package ifsp.bishappy.model.batimento;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaBatimentos(
	 @NotNull
	 long id,
	 
	 int bpm) {

}
