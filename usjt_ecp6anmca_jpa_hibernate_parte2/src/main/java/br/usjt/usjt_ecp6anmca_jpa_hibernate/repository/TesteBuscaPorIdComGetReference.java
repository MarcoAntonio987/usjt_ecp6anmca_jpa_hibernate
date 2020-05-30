package br.usjt.usjt_ecp6anmca_jpa_hibernate.repository;

import javax.persistence.EntityManager;

import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Previsao;

public class TesteBuscaPorIdComGetReference {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		Previsao u = manager.getReference(Previsao.class, 1L);
		System.out.println(u);
		manager.close();
		JPAUtil.close();
	}

}
