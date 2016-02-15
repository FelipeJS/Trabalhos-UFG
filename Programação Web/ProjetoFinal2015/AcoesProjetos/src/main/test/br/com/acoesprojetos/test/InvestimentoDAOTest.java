//package br.com.acoesprojetos.test;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//import br.com.acoesprojetos.dao.AcaoDAO;
//import br.com.acoesprojetos.dao.InvestimentoDAO;
//import br.com.acoesprojetos.model.Acao;
//import br.com.acoesprojetos.model.Investimento;
//
//public class InvestimentoDAOTest {
//	
//	@Ignore
//	@Test
//	public void salvar(){
//		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
//		AcaoDAO acaoDAO = new AcaoDAO();
//		Investimento investimento = new Investimento();
//		
//		Acao acao = acaoDAO.buscarPorCodigo(2L); 
//		
//		investimento.setAcao(acao);
//		investimento.setValor(100);
//		investimento.setQuantidade(2);
//		investimento.setTotal(200);
//		
//		investimentoDAO.salvar(investimento);
//	}
//	
//	@Ignore
//	@Test
//	public void listar(){
//		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
//		System.out.println(investimentoDAO.listar());
//	}
//	
//	@Ignore
//	@Test
//	public void buscarPorCodigo(){
//		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
//		Investimento investimento = investimentoDAO.buscarPorCodigo(2L);
//		
//		System.out.println(investimento);
//	}
//	
//	@Ignore
//	@Test
//	public void excluir(){
//		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
//		Investimento investimento = investimentoDAO.buscarPorCodigo(1L);
//		investimentoDAO.excluir(investimento);
//	}
//	
//	@Ignore
//	@Test
//	public void editar(){
//		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
//		Investimento investimento = investimentoDAO.buscarPorCodigo(1L);
//		investimento.setQuantidade(4);
//		investimento.setTotal(300.00);
//		
//		investimentoDAO.editar(investimento);
//	}
//}
