package br.usjt.usjt_ecp6anmca_jpa_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Semana;

public class TesteRemoveDiaDaSemanaComPrevisaoAssociada {
	
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Semana s = manager.find(Semana.class, 1L);
		manager.remove(s);
		manager.close();
		JPAUtil.close();
		}
}


