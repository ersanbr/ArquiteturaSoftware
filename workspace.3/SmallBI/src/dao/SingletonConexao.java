package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonConexao {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("smallbiArqSoft");
	
	public static EntityManager getInstance(){
		return emf.createEntityManager();
	}
}
