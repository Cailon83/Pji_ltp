package ifsp.bishappy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.bishappy.model.aluno.Aluno;
import ifsp.bishappy.model.aluno.AlunoRepository;
import ifsp.bishappy.model.aluno.AlunoService;
import ifsp.bishappy.model.aluno.DadosAtualizaAluno;
import ifsp.bishappy.model.aluno.DadosCadastroAluno;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private AlunoService alunoService;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
		//System.out.println(dados.toString());
	    repository.save( new Aluno(dados));
	}
	
	@GetMapping                                           
	public List<Aluno> Listagem (){    
	    return alunoService.listarAlunos();                     
	} 
	
	@GetMapping("/{id}")                                           
	public Aluno ListaUmAluno (@PathVariable Long id){  
	    return alunoService.getAlunoById(id);          
	} 
	
	@GetMapping( "/nome/{nome}")  
	public Optional<Aluno> ListaUmAluno (@PathVariable String nome){  
	    return alunoService.buscarAlunoPorNome(nome);          
	} 
	
	@PutMapping
	@Transactional
	public void atualizar (@RequestBody @Valid DadosAtualizaAluno dados) {
		var aluno = repository.getReferenceById(dados.id());
		aluno.atualizarInformacoes(dados);
	}
	
	@DeleteMapping ("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
