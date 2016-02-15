package br.com.acoesprojetos.service;

import java.util.List;

import br.com.acoesprojetos.dao.InvestimentoDAO;
import br.com.acoesprojetos.model.Acao;
import br.com.acoesprojetos.model.Investimento;

// TODO: Auto-generated Javadoc
/**
 * The Class InvestimentoService.
 */
public class InvestimentoService {

	/** The dao. */
	InvestimentoDAO dao;
	AcaoService acaoService = new AcaoService();

	/**
	 * Instantiates a new investimento service.
	 */
	public InvestimentoService() {
		dao = new InvestimentoDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Salvar.
	 *
	 * @param investimento
	 *            the investimento
	 */
	public void salvar(Investimento inv) throws Exception {
		
		Acao acao = acaoService.buscaId(inv.getAcao().getId());
		acao.somaPreco(inv.getTotal());
		acao.somaQuantidade(inv.getQuantidade());
		acaoService.editar(acao);

		dao.inserir(inv);
	}

	/**
	 * Editar.
	 *
	 * @param inv
	 *            the inv
	 */
	public void editar(Investimento inv) {
		
		int id = inv.getId();
		//aqui tem que vir o valor do investimento que está no banco de dados para fazer a subtração
		Investimento invest= this.buscaId(id);
		
		Acao acao = acaoService.buscaId(inv.getAcao().getId());
		acao.somaPreco(inv.getTotal() - invest.getTotal());
		acao.somaQuantidade(inv.getQuantidade() - invest.getQuantidade());
		acaoService.editar(acao);
		
		dao.atualizar(inv);
	}

	/**
	 * Listar.
	 *
	 * @param acao
	 *            the acao
	 * @return the list
	 */
	public List<Investimento> listar() {
		return dao.getLista();
	}

	/**
	 * Excluir.
	 *
	 * @param id
	 *            the id
	 */
	public void excluir(int id) {
		AcaoService acaoService = new AcaoService();
		Investimento inv = dao.findById(id);

		Acao acao = acaoService.buscaId(inv.getAcao().getId());
		acao.subtraiPreco(inv.getTotal());
		acao.subtraiQuantidade(inv.getQuantidade());
		acaoService.editar(acao);

		dao.delete(new Investimento(), id);
	}

	/**
	 * Busca id.
	 *
	 * @param id
	 *            the id
	 * @return the investimento
	 */
	public Investimento buscaId(int id) {
		return dao.findById(id);
	}

	/**
	 * Busca lista por acao.
	 *
	 * @param acao
	 *            the acao
	 * @return the list
	 */
	public List<Investimento> buscaListaPorAcao(Acao acao) {
		return dao.buscaListaPorAcao(acao);
	}
}
