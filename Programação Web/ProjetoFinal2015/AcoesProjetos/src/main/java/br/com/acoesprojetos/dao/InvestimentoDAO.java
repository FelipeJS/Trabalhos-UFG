package br.com.acoesprojetos.dao;

import java.util.List;

import br.com.acoesprojetos.model.Acao;
import br.com.acoesprojetos.model.Investimento;

// TODO: Auto-generated Javadoc
/**
 * The Class InvestimentoDAO.
 */
public class InvestimentoDAO extends BaseDao<Investimento, Integer>{

	/**
	 * Busca lista por acao.
	 *
	 * @param acao the acao
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Investimento> buscaListaPorAcao(Acao acao) {
		List<Investimento> lista = null;
		lista = super.getEntityManager().createNamedQuery("Investimento.listarporAcao")
				.setParameter("acao_id", acao).getResultList();
		
		return lista;
	}

}
