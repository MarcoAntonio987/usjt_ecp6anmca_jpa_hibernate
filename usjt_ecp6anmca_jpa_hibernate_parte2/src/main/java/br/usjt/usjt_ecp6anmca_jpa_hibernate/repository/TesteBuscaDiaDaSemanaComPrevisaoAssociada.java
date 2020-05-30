package br.usjt.usjt_ecp6anmca_jpa_hibernate.repository;

import javax.persistence.EntityManager;

import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Semana;

public class TesteBuscaDiaDaSemanaComPrevisaoAssociada {
	
		public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		Semana s = manager.find(Semana.class, 1L);
		System.out.println(s);
		manager.close();
		JPAUtil.close();
		}
		

}
