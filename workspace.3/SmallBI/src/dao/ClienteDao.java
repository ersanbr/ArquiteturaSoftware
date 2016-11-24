package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Cliente;

public class ClienteDao implements InterfaceDao<Cliente>{

	@Override
	public void createObj(Cliente cliente){		
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public List<Cliente> listObj() {
		EntityManager em = SingletonConexao.getInstance();
		Query q = em.createQuery("SELECT c FROM Cliente c");
		return q.getResultList();
	}

	@Override
	public void updateObj(Cliente cliente) {
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public void removeObj(Cliente cliente) {
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		em.close();			
	}

	@Override
	public Cliente getObjById(Integer id) {
		EntityManager em = SingletonConexao.getInstance();
		return em.find(Cliente.class, id);
	}	
}
