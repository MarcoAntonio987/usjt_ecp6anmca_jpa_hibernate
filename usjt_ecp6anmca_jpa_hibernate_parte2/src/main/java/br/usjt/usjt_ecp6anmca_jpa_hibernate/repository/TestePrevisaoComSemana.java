package br.usjt.usjt_ecp6anmca_jpa_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Previsao;
import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Semana;

public class TestePrevisaoComSemana {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Semana p = new Semana();
		p.setNome("Sexta");
		manager.persist(p);
		Previsao u = new Previsao();
		u.setTempMin("24°C");
		u.setTempMax("30°C");
		u.setHumidade("49%");
		u.setDataHora("2020-05-25T20:42");
		u.setDescricao("tarde");	
		u.setSemana(p);
		manager.persist(u);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}
