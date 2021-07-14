package br.fuctura.JpaUtil;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("TrabalhoJpa");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static void close() {
		factory.close();
	}
}
