package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import entity.Usuario;

public class UsuarioDao implements InterfaceDao<Usuario>{

	@Override
	public void createObj(Usuario usuario) {
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listObj() {
		EntityManager em = SingletonConexao.getInstance();
		Query q = em.createQuery("SELECT u FROM Usuario u");
		return q.getResultList();
	}

	@Override
	public void updateObj(Usuario usuario) {
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public void removeObj(Usuario usuario) {
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Usuario getObjById(Integer id) {
		EntityManager em = SingletonConexao.getInstance();
		return em.find(Usuario.class, id);
	}
}
