package business;

import java.util.List;

import dao.FactoryDao;
import dao.InterfaceDao;
import entity.Plano;

public class BusinessPlano implements InterfaceBusiness<Plano>{

	@Override
	public void save(Plano plano) {	
		
		if(plano.getNome().equals(null) || plano.getNome().equals("")){
			System.out.println("O nome deve ser informado!");
			//throw new Exception("Business Erro: O nome deve ser informado!");
		}
		
		InterfaceDao<Plano> dao = FactoryDao.createPlanoDao();
		dao.createObj(plano);
	}
	
	@Override
	public List<Plano> list() {
		InterfaceDao<Plano> dao = FactoryDao.createPlanoDao();
		List<Plano> plano = dao.listObj();
		return plano;
	}
	
	@Override
	public void update(Plano plano) {
		if(plano.getNome().equals(null) || plano.getNome().equals("")){
			//error
		}		
		
		InterfaceDao<Plano> dao = FactoryDao.createPlanoDao();
		dao.updateObj(plano);
	}

	@Override
	public Plano getObj(Integer id) {
		InterfaceDao<Plano> dao = FactoryDao.createPlanoDao();
		Plano plano = dao.getObjById(id);
		return plano;
	}

	@Override
	public void delete(Integer id) {
		InterfaceDao<Plano> dao = FactoryDao.createPlanoDao();
		Plano plano = getObj(id);
		dao.removeObj(plano);
	}
}
