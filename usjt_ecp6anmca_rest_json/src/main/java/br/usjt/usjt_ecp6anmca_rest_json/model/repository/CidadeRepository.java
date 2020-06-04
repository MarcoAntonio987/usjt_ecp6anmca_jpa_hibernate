package br.usjt.usjt_ecp6anmca_rest_json.model.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.usjt_ecp6anmca_rest_json.model.beans.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade,Long>{

	List<Cidade> findByletraInicial(String letraInicial);
	List<Cidade> findByLatitudeAndLongitude( String latitude, String longitude) ;

	


}
