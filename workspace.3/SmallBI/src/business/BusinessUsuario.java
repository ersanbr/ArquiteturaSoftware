package business;

import java.util.List;

import dao.FactoryDao;
import dao.InterfaceDao;
import entity.Cliente;
import entity.Usuario;

public class BusinessUsuario implements InterfaceBusiness<Usuario>{
	
	@Override
	public void save(Usuario usuario){		
		if(usuario.getNome().equals(null) || usuario.getNome().equals("")){
			//Error
		}		
		if(usuario.getLogin().equals(null) || usuario.getLogin().equals("")){
			//Error
		}		
		if(usuario.getSenha().equals(null) || usuario.getSenha().equals("")){
			//Error
		}
		
		InterfaceDao<Cliente> daoCliente = FactoryDao.createClienteDao();				
		Cliente cliente = daoCliente.getObjById(usuario.getCliente().getId());
		
		if(cliente == null){
			//Error
		}else{
			usuario.setCliente(cliente);
		}
		
		InterfaceDao<Usuario> daoUsuario = FactoryDao.createUsuarioDao();
		daoUsuario.createObj(usuario);
	}
	
	@Override
	public List<Usuario> list(){
		InterfaceDao<Usuario> dao = FactoryDao.createUsuarioDao();
		return dao.listObj();
	}
	

	@Override
	public void update(Usuario usuario){		
		if(usuario.getNome().equals(null) || usuario.getNome().equals("")){
			//Error
		}		
		if(usuario.getLogin().equals(null) || usuario.getLogin().equals("")){
			//Error
		}		
		if(usuario.getSenha().equals(null) || usuario.getSenha().equals("")){
			//Error
		}		
		
		InterfaceDao<Cliente> daoCliente = FactoryDao.createClienteDao();				
		Cliente cliente = daoCliente.getObjById(usuario.getCliente().getId());
		
		if(cliente == null){
			//Error
		}else{
			usuario.setCliente(cliente);
		}
		
		InterfaceDao<Usuario> daoUsuario = FactoryDao.createUsuarioDao();
		daoUsuario.updateObj(usuario);
	}

	@Override
	public Usuario getObj(Integer id) {
		InterfaceDao<Usuario> dao = FactoryDao.createUsuarioDao();
		return dao.getObjById(id);
	}

	@Override
	public void delete(Integer id) {
		InterfaceDao<Usuario> dao = FactoryDao.createUsuarioDao();
		Usuario usuario = dao.getObjById(id);
		dao.removeObj(usuario);
	}
}
