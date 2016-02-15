package br.com.acoesprojetos.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.acoesprojetos.dao.AcaoDAO;
import br.com.acoesprojetos.dao.UsuarioDAO;
import br.com.acoesprojetos.model.Acao;

public class AcaoDAOTest {
	
	@Ignore
	@Test
	public void salvar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		Acao acao = new Acao();
		acao.setUsuario(usuarioDAO.findById(1));
		acao.setNome("Petrobras");

		AcaoDAO acaoDAO = new AcaoDAO();
		acaoDAO.inserir(acao);
	}

	@Test
	public void listar() {
		AcaoDAO dao = new AcaoDAO();
		System.out.println(dao.getLista());
	}

	@Ignore
	@Test
	public void buscarPorCodigo() {
		AcaoDAO dao = new AcaoDAO();
		System.out.println(dao.findById(1));
	}

	@Ignore
	@Test
	public void excluir() {
		AcaoDAO dao = new AcaoDAO();
		dao.delete(new Acao(), 1);
	}

	@Ignore
	@Test
	public void editar() {
		AcaoDAO acaoDAO = new AcaoDAO();
		Acao acao = new Acao();

		acao.setNome("IBM alterado");
		acaoDAO.atualizar(acao);
	}
}
