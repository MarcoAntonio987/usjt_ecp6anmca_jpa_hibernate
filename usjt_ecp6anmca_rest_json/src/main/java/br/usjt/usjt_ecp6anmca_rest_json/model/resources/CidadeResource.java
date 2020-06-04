package br.usjt.usjt_ecp6anmca_rest_json.model.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.usjt.usjt_ecp6anmca_rest_json.model.beans.Cidade;
import br.usjt.usjt_ecp6anmca_rest_json.model.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
	@Autowired
	private CidadeRepository cidadeRepo;
	
	//1. Listar todas as cidades.
	@GetMapping("/lista")
	public List<Cidade> todosAsCidades(){
	return cidadeRepo.findAll();
	}
	
	
	//4. Cadastrar novas cidades.
	@PostMapping("/salvar")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade) {
		Cidade l = cidadeRepo.save(cidade);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentServletMapping().path("/{id}").
				buildAndExpand(l.getId()).
				toUri();
		//response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(l);
	}
	
	@GetMapping("/{id}")
	public Cidade buscarPeloId(@PathVariable Long  id) {
		return cidadeRepo.getOne(id);
	}
	
	//2. Listar todas as cidades cujo nome começa com uma letra específica.
	@GetMapping("/letraInicial/{letraInicial}")
	public List<Cidade> buscarPelaLetra( @PathVariable String letraInicial) {
	
		return cidadeRepo.findByletraInicial(letraInicial);
	}
	
	
	//3. Obter uma cidade por sua latitude e longitude.
	@GetMapping("/latitude/{latitude}/longitude/{longitude}")
	public List<Cidade> buscarPelaLatitude( @PathVariable String latitude, @PathVariable String longitude) {
	
		return cidadeRepo.findByLatitudeAndLongitude(latitude, longitude);
		
	}
	
	
		

/*	@PutMapping("/atualizar")
	public ResponseEntity<Cidade> atualizar(@RequestBody Cidade cidade){
		Cidade l = cidadeRepo.findById(cidade.getId()).get();
		/* Precisa copiar os atributos de livro para l
		 * se fizer l = livro você tira o livro que atachou na
		 * persitência e coloca um novo. Aí vai inserir em vez
		 * de atualizar.
		 */
/*		l.setNome(cidade.getNome());
		l.setLatitude(cidade.getLatitude());
		l.setLongitude(cidade.getLongitude());
		l = cidadeRepo.save(l);
		return ResponseEntity.status(HttpStatus.OK).body(l);
	}

	@DeleteMapping("/{id}")
	public void excluirPeloId(@PathVariable Long id) {
		Cidade l =  cidadeRepo.getOne(id);
		cidadeRepo.delete(l);

	}*/
	
}






