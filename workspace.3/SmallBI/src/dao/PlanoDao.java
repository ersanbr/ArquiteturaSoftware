package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Plano;

public class PlanoDao implements InterfaceDao<Plano>{

	@Override
	public void createObj(Plano plano) {
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.persist(plano);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plano> listObj() {
		EntityManager em = SingletonConexao.getInstance();
		Query q = em.createQuery("SELECT p FROM Plano p");
		return q.getResultList();
	}

	@Override
	public void updateObj(Plano plano) {
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.merge(plano);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void removeObj(Plano plano) {
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.remove(plano);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Plano getObjById(Integer id) {
		EntityManager em = SingletonConexao.getInstance();
		return em.find(Plano.class, id);
	}
}
