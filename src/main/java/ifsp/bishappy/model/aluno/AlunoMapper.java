package ifsp.bishappy.model.aluno;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface AlunoMapper {
	//AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);
	DadosListagemAluno mapAlunoToDto (Aluno aluno);
	Aluno mapDtoToAluno (DadosListagemAluno dto);
	List<DadosListagemAluno> listaDtos (List<Aluno> alunos);

}
