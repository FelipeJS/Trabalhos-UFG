package br.com.acoesprojetos.conectionFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.acoesprojetos.dao.AcaoDAO;
import br.com.acoesprojetos.dao.InvestimentoDAO;
import br.com.acoesprojetos.dao.UsuarioDAO;

public final class DaoFactory {

	// Trocar aqui para qual banco ser� usado de acordo com persistence.xml
	private static final String PERSISTENCE_UNIT_NAME = "Derby";
	private static EntityManagerFactory entityManagerFactoryInstance;
	
	private static AcaoDAO acaoDao;
	private static InvestimentoDAO investimentoDao;
	private static UsuarioDAO usuarioDao;
	
	private DaoFactory(){}
	
	public static EntityManagerFactory entiManagerFactoryInstance() {
		
		if(entityManagerFactoryInstance == null)
			entityManagerFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		return entityManagerFactoryInstance;
	}
	
	public static AcaoDAO acaoDaoInstance() {
		if(acaoDao == null)
			acaoDao = new AcaoDAO();
		
		return acaoDao;
	}
	
	public static InvestimentoDAO investimentoDaoInstance() {
		if(investimentoDao == null)
			investimentoDao = new InvestimentoDAO();
		
		return investimentoDao;
	}
	
	public static UsuarioDAO usuarioDaoInstance() {
		if(usuarioDao == null)
			usuarioDao = new UsuarioDAO();
		
		return usuarioDao;
	}


}
