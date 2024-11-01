package ifsp.bishappy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ifsp.bishappy.model.aluno.AlunoService;
import ifsp.bishappy.model.batimento.Batimentos;
import ifsp.bishappy.model.batimento.BatimentosRepository;
import ifsp.bishappy.model.batimento.BatimentosService;
import ifsp.bishappy.model.batimento.DadosAtualizaBatimentos;
import ifsp.bishappy.model.batimento.DadosCadastroBatimentos;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("batimentos")
public class BatimentosController {
	
	@Autowired
	private BatimentosRepository repository;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private BatimentosService batimentoService;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody DadosCadastroBatimentos dados) {
		var aluno = alunoService.getAlunoById(dados.alunoId());
		var batimento = new Batimentos(dados, aluno);
		//System.out.println(dados.toString());
	    repository.save(batimento);
	}
	
	@GetMapping                                           
	public List<Batimentos> Listagem (){    
//		if (batimentoService.listarBatimentos().isEmpty())
//			System.out.println("Listavazia");
	    return batimentoService.listarBatimentos();                     
	} 
	
	@GetMapping("/{id}")                                           
	public Batimentos ListaBatimentos (@PathVariable Long id){  
	    return batimentoService.getBatimentosById(id);          
	} 
	
	@PutMapping
	@Transactional
	public void atualizar (@RequestBody @Valid DadosAtualizaBatimentos dados) {
		var batimentos = repository.getReferenceById(dados.id());
		batimentos.atualizarInformacoes(dados);
	}
	
	@DeleteMapping ("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
