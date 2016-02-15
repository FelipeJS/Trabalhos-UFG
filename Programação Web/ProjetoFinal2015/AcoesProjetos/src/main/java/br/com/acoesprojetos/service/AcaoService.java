package br.com.acoesprojetos.service;

import java.util.List;

import br.com.acoesprojetos.dao.AcaoDAO;
import br.com.acoesprojetos.model.Acao;

public class AcaoService {
	AcaoDAO dao;

	public AcaoService() {
		dao = new AcaoDAO();
	}

	public void salvar(Acao acao) throws Exception {
		dao.inserir(acao);
	}

	public void editar(Acao acao) {
		dao.atualizar(acao);
	}

	public List<Acao> listar() {
		return dao.getLista();
	}

	public void excluir(int id) {
		dao.delete(new Acao(), id);
	}

	public Acao buscaId(int id) {
		return dao.findById(id);
	}
}