package br.usjt.usjt_ecp6anmca_jpa_hibernate.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Cidade;
import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.PrevisoesParaCidade;

public class TesteInsereDuasPrevisoesEmUmaCidade {

		public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Cidade c = new Cidade();
		c.setNome("são paulo");
		c.setLatitude("45º");
		c.setLongitude("45º");
		
		
		List <PrevisoesParaCidade> previsoes = new ArrayList <>();
		PrevisoesParaCidade pc1 = new PrevisoesParaCidade();
		pc1.setDataHora("28/05/2020T18:36");
		pc1.setTempMin("10ºC");
		pc1.setTempMax("15ºC");
		pc1.setUmidAr("80%");
		pc1.setDescricao("Nublado com possibilidade de chuva");
		pc1.setCidade(c);
		
		
		PrevisoesParaCidade pc2 = new PrevisoesParaCidade ();
		pc2.setDataHora("29/05/2020T19:00");
		pc2.setTempMin("12ºC");
		pc2.setTempMax("14ºC");
		pc2.setUmidAr("70%");
		pc2.setDescricao("Céu aberto com possibilidade de geada");
		pc2.setCidade(c);
		
		
		previsoes.add(pc1);
		previsoes.add(pc2);
		c.setPrevisoesparacidade(previsoes);
		manager.persist(c);
		transaction.commit();
		manager.close();
		JPAUtil.close();
		}
}
		

