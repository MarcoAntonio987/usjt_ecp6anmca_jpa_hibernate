package br.usjt.usjt_ecp6anmca_jpa_hibernate.repository;

import javax.persistence.EntityManager;

import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Cidade;

public class TesteBuscaUmParaN {
	
		public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		Cidade c = manager.find(Cidade.class, 6L);
		System.out.println(c.getPrevisoesparacidade());
		manager.close();
		JPAUtil.close();
		}


}
