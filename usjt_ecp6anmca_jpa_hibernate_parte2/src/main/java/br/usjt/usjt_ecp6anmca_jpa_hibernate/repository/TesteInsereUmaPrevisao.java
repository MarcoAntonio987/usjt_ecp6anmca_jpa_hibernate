package br.usjt.usjt_ecp6anmca_jpa_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Previsao;

public class TesteInsereUmaPrevisao {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Previsao u = new Previsao();
		u.setTempMin("15°C");
		u.setTempMax("22°C");
		u.setHumidade("70%");
		u.setDataHora("2020-05-25T20:11");
		u.setDescricao("noite");		
		manager.persist(u);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}
