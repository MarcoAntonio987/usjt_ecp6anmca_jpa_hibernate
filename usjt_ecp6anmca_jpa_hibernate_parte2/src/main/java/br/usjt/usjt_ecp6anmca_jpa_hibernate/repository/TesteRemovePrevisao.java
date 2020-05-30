package br.usjt.usjt_ecp6anmca_jpa_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Previsao;

public class TesteRemovePrevisao {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Previsao u = manager.find(Previsao.class, 1L);
		manager.remove(u);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}
