package test;

import java.util.List;

import org.junit.Test;

import business.BusinessPlano;
import entity.Plano;

public class TestGetPlan {

	@Test
	public void getNewPlano(){
		Plano plano = new Plano();
		plano.setNome("Free 2.0");
		plano.setDescricao("Blabla");
		
		new BusinessPlano().save(plano);
	}
	
	@Test
	public void listPlano(){
		List<Plano> planos = new BusinessPlano().list();
		
		for(Plano p : planos){
			System.out.println("Nome do plano: " + p.getNome());
			System.out.println("Descrição do planon: " + p.getDescricao());
		}
	}
	
//	@Test
//	public void updatePlan(){
//		Plan plan = new BusinessPlan().getObj(8);
//		
//		plan.setName("Plan Ultimate");
//		plan.setDescription("Plan very good");
//		
//		new BusinessPlan().update(plan);
//	}
	
//	@Test
//	public void deletePlan(){
//		new BusinessPlan().delete(12);
//	}
}
