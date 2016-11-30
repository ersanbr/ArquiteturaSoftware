package business;

import java.util.List;

import dao.FactoryDao;
import dao.InterfaceDao;
import entity.Cliente;

public class BusinessCliente implements InterfaceBusiness<Cliente>{

	@Override
	public void save(Cliente cliente) {
		
		if(cliente.getNome().equals(null) || cliente.getNome().equals("")){
			System.out.println("O nome deve ser informado!");
			//throw new Exception("Business Erro: O nome deve ser informado!");
		}
		
		InterfaceDao<Cliente> dao = FactoryDao.createClienteDao();
		dao.createObj(cliente);
	}
	
	@Override
	public List<Cliente> list(){
		InterfaceDao<Cliente> dao = FactoryDao.createClienteDao();
		List<Cliente> clientes = dao.listObj();
		return clientes;
	}
	
	@Override
	public void update(Cliente cliente){
		if(cliente.getNome().equals(null) || cliente.getNome().equals("")){
			System.out.println("O nome deve ser informado!");
		}
		
		InterfaceDao<Cliente> dao = FactoryDao.createClienteDao();
		dao.updateObj(cliente);
	}

	@Override
	public Cliente getObj(Integer id) {
		InterfaceDao<Cliente> dao = FactoryDao.createClienteDao();
		Cliente cliente = dao.getObjById(id);
		return cliente;
	}

	@Override
	public void delete(Integer id) {
		InterfaceDao<Cliente> dao = FactoryDao.createClienteDao();
		Cliente cliente = dao.getObjById(id);
		dao.removeObj(cliente);
	}
}
