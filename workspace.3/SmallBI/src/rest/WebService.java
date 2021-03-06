package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import business.BusinessCliente;
import business.BusinessPlano;
import business.BusinessUsuario;
import entity.Cliente;
import entity.Plano;
import entity.Usuario;

@Path("/smallbi")
public class WebService {
	
	@GET
	@Path("/clientes/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getClientes(){
		List<Cliente> clientesList = new BusinessCliente().list();
		return clientesList;
	}
	
	@POST
	@Path("/clientes/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCliente(Cliente cliente){
		new BusinessCliente().save(cliente);
	}
	
	@GET
	@Path("/planos/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Plano> getPlanos(){
		return new BusinessPlano().list();
	}
	
	@POST
	@Path("/planos/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createPlano(Plano plano){
		new BusinessPlano().save(plano);
	}
	
	@GET
	@Path("/usuarios/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios(){
		return new BusinessUsuario().list();
	}
	
	@POST
	@Path("/usuarios/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUsuario(Usuario usuario){
		new BusinessUsuario().save(usuario);
	}

}
