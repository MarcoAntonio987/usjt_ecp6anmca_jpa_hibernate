package br.usjt.usjt_ecp6anmca_jpa_hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Previsao;

public class TesteListaTodosJPQL {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		Query query = manager.createQuery("from Previsao");
		List<Previsao> previsoes = query.getResultList();
		for(Previsao u:previsoes) {
			System.out.println(u);
		}
		manager.close();
		JPAUtil.close();

	}

}
