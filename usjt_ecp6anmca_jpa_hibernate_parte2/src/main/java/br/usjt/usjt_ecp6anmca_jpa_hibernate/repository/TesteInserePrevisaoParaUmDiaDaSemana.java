package br.usjt.usjt_ecp6anmca_jpa_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Previsao;
import br.usjt.usjt_ecp6anmca_jpa_hibernate.entity.Semana;

public class TesteInserePrevisaoParaUmDiaDaSemana {
	
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Semana s = new Semana();
		s.setNome("Sexta");
		manager.persist(s);
		Previsao p = new Previsao();
		p.setTempMin("18°C");
		p.setTempMax("25°C");
		p.setDataHora("2020-06-02T00:00");
		p.setDescricao("Chuvoso");	
		p.setSemana(s);
		manager.persist(p);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}

