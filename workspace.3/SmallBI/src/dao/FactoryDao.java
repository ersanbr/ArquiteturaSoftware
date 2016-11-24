package dao;

import entity.Cliente;
import entity.Plano;
import entity.Usuario;

public class FactoryDao {

	public static InterfaceDao<Cliente> createClienteDao(){
		return new ClienteDao();
	}
	
	public static InterfaceDao<Usuario> createUsuarioDao(){
		return new UsuarioDao();
	}
	
	public static InterfaceDao<Plano> createPlanoDao(){
		return new PlanoDao();
	}
}
