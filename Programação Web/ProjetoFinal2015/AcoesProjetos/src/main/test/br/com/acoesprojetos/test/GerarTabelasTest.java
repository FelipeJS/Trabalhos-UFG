package br.com.acoesprojetos.test;

import javax.persistence.Persistence;

import org.junit.Test;

import br.com.acoesprojetos.conectionFactory.DaoFactory;

public class GerarTabelasTest {
	
	@Test
	public void gerar(){
//		HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().close();
//		Persistence.createEntityManagerFactory("Derby");
//		Persistence.createEntityManagerFactory("Derby").close();
		
		DaoFactory.entiManagerFactoryInstance();
		DaoFactory.entiManagerFactoryInstance().close();
		
		
		
	}
	
	
	
}
