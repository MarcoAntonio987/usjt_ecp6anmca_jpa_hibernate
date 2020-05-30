package br.usjt.usjt_ecp6anmca_jpa_hibernate.repository;

import javax.persistence.Persistence;

public class TesteCriarBaseETabelas {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("usjtPU");
	}

}
