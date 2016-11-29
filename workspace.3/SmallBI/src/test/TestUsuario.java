package test;

import java.util.List;

import org.junit.Test;

import business.BusinessUsuario;
import entity.Usuario;

public class TestUsuario {

	@Test
	public void createUsuario(){
		
		Usuario usuario = new Usuario();
		usuario.setNome("Huguinho");
		usuario.setLogin("zezinho");
		usuario.setSenha("hug123");
		
		
		new BusinessUsuario().save(usuario);
	}
	
	@Test
	public void listUsuario(){
		List<Usuario> usuarios = new BusinessUsuario().list();
		
		for(Usuario usuario : usuarios){
			System.out.println("Usuário: " + usuario.getNome());
			System.out.println("Login: " + usuario.getLogin());
			System.out.println("Senha: " + usuario.getSenha());
		}
	}
	
//	@Test
//	public void updateUsuario(){
//		Usuario usuario = new BusinessUsuario().getObj(9);
//		usuario.setNome("Huguinho");
//		usuario.setLogin("hugo");
//		usuario.setSenha("hug123");
//		
//		Cliente cliente = new Cliente();
//		cliente.setId(4);
//		usuario.setCliente(cliente);
//		
//		new BusinessUsuario().update(usuario);
//	}
	
//	@Test
//	public void deleteUsuario(){
//		new BusinessUsuario().delete(6);
//	}
}
