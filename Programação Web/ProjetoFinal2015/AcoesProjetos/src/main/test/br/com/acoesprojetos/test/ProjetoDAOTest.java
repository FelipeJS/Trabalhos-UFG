//package br.com.acoesprojetos.test;
//
//import java.util.Date;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//import br.com.acoesprojetos.dao.ProjetoDAO;
//import br.com.acoesprojetos.dao.UsuarioDAO;
//import br.com.acoesprojetos.model.Projeto;
//import br.com.acoesprojetos.model.Usuario;
//
//public class ProjetoDAOTest {
//	
//	@Ignore
//	@Test
//	public void salvar(){
//		ProjetoDAO projetoDAO = new ProjetoDAO();
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		Projeto projeto = new Projeto();
//		Usuario usuario = usuarioDAO.findById(1);
//		
//		projeto.setUsuario(usuario);
//		projeto.setNome("Predio");
//		projeto.setStatus(1);
//		projeto.setDataInicio(new Date());
//		
//		projetoDAO.inserir(projeto);
//	}
//	
//	@Ignore
//	@Test
//	public void listar(){
//		ProjetoDAO projetoDAO = new ProjetoDAO();
//		System.out.println(projetoDAO.listar());
//	}
//	
//	@Ignore
//	@Test
//	public void buscarPorCodigo(){
//		ProjetoDAO projetoDAO = new ProjetoDAO();
//		System.out.println(projetoDAO.buscarPorCodigo(2L));
//	}
//	
//	@Ignore
//	@Test
//	public void excluir(){
//		ProjetoDAO projetoDAO = new ProjetoDAO();
//		Projeto projeto = projetoDAO.buscarPorCodigo(1L);
//		projetoDAO.excluir(projeto);
//	}
//	
//	@Ignore
//	@Test
//	public void editar(){
//		ProjetoDAO projetoDAO = new ProjetoDAO();
//		Projeto projeto = projetoDAO.buscarPorCodigo(1L);
//		projeto.setNome("Novidade");
//		projetoDAO.editar(projeto);
//	}
//}
