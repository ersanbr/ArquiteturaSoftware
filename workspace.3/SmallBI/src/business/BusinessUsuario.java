package business;

import java.util.List;

import dao.FactoryDao;
import dao.InterfaceDao;
import entity.Usuario;

public class BusinessUsuario implements InterfaceBusiness<Usuario> {

	@Override
	public void save(Usuario usuario) {
		if (usuario.getNome().equals(null) || usuario.getNome().equals("")) {
			System.out.println("O nome deve ser informado!");
			// Error
		}

		InterfaceDao<Usuario> dao = FactoryDao.createUsuarioDao();
		dao.createObj(usuario);
	}

	@Override
	public List<Usuario> list() {
		InterfaceDao<Usuario> dao = FactoryDao.createUsuarioDao();
		List<Usuario> usuarios = dao.listObj();
		return usuarios;
	}

	@Override
	public void update(Usuario usuario) {
		if (usuario.getNome().equals(null) || usuario.getNome().equals("")) {
			System.out.println("O nome deve ser informado!");
		}

		InterfaceDao<Usuario> dao = FactoryDao.createUsuarioDao();
		dao.updateObj(usuario);
	}

	@Override
	public Usuario getObj(Integer id) {
		InterfaceDao<Usuario> dao = FactoryDao.createUsuarioDao();
		Usuario usuario = dao.getObjById(id);
		return usuario;
	}

	@Override
	public void delete(Integer id) {
		InterfaceDao<Usuario> dao = FactoryDao.createUsuarioDao();
		Usuario usuario = dao.getObjById(id);
		dao.removeObj(usuario);
	}
}
