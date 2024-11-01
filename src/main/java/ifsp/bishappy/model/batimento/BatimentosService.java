package ifsp.bishappy.model.batimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatimentosService {
	
	@Autowired
	private BatimentosRepository batimentosRepository;
	
	@Autowired
	public BatimentosService(BatimentosRepository batimentosRepository) {
		this.batimentosRepository = batimentosRepository;
	}
	
	public Batimentos getBatimentosById(Long id) {
		return batimentosRepository.getReferenceById(id);
	}
	
	public List<Batimentos> listarBatimentos() {
		return batimentosRepository.findAll();
	}
	
	
	
}
